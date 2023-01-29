package com.andes.metamon.core.di

import com.andes.metamon.auth.data.remote.service.LoginService
import com.andes.metamon.core.data.remote.service.CertificateService
import com.andes.metamon.core.di.annotations.MetamonServer
import com.andes.metamon.main.home.data.remote.service.IdCardService
import com.andes.metamon.main.profile.data.remote.service.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitServiceModule {

    @Provides
    @Singleton
    fun provideLoginService(@MetamonServer retrofit: Retrofit): LoginService =
        retrofit.create(LoginService::class.java)

    @Provides
    @Singleton
    fun provideCertificateService(@MetamonServer retrofit: Retrofit): CertificateService =
        retrofit.create(CertificateService::class.java)

    @Provides
    @Singleton
    fun provideIdCardService(@MetamonServer retrofit: Retrofit): IdCardService =
        retrofit.create(IdCardService::class.java)

    @Provides
    @Singleton
    fun provideProfileService(@MetamonServer retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)
}
