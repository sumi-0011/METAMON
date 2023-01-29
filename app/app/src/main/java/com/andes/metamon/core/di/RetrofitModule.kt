package com.andes.metamon.core.di

import com.andes.metamon.BuildConfig.*
import com.andes.metamon.core.data.local.data_source.LocalPreferenceUserDataSource
import com.andes.metamon.core.data.remote.call_adapter.CustomCallAdapterFactory
import com.andes.metamon.core.di.annotations.MetamonServer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private const val AUTHORIZATION = "Authorization"
    private const val BEARER = "Bearer "

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    @MetamonServer
    fun providesDameDameInterceptor(localPreferenceUserDataSourceImpl: LocalPreferenceUserDataSource): Interceptor =
        Interceptor { chain ->
            with(chain) {
                proceed(
                    request()
                        .newBuilder()
                        .addHeader(
                            AUTHORIZATION,
                            BEARER + localPreferenceUserDataSourceImpl.getAccessToken()
                        )
                        .build()
                )
            }
        }

    @Provides
    @Singleton
    @MetamonServer
    fun provideMetamonOkHttpClient(
        @MetamonServer interceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    @MetamonServer
    fun providesMetamonRetrofit(@MetamonServer okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(if (DEBUG) METAMON_SERVER_BASE_URL_DEBUG else METAMON_SERVER_BASE_URL_RELEASE)
            .client(okHttpClient)
            .addCallAdapterFactory(CustomCallAdapterFactory())
            .addConverterFactory(nullOnEmptyConverterFactory)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
}

/**
 * @author onseok
 *
 * 서버로부터 response body 자체가 null인 경우,
 * 즉, 비어있는(length=0)인 response를 받았을 경우,
 * 앱이 터지지 않도록,
 * 이에 대한 예외를 처리하는 역할을 합니다.
 */
private val nullOnEmptyConverterFactory = object : Converter.Factory() {
    fun converterFactory() = this
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ) = object :
        Converter<ResponseBody, Any?> {
        val nextResponseBodyConverter =
            retrofit.nextResponseBodyConverter<Any?>(converterFactory(), type, annotations)

        override fun convert(value: ResponseBody) =
            if (value.contentLength() != 0L) nextResponseBodyConverter.convert(value) else null
    }
}