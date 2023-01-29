package com.andes.metamon.core.di

import com.andes.metamon.auth.data.remote.data_source.RemoteLoginDataSource
import com.andes.metamon.auth.data.remote.data_source.RemoteLoginDataSourceImpl
import com.andes.metamon.core.data.remote.data_source.RemoteCertificateDataSource
import com.andes.metamon.core.data.remote.data_source.RemoteCertificateDataSourceImpl
import com.andes.metamon.main.home.data.remote.data_source.RemoteHomeDataSource
import com.andes.metamon.main.home.data.remote.data_source.RemoteHomeDataSourceImpl
import com.andes.metamon.main.profile.data.remote.data_source.RemoteProfileDataSource
import com.andes.metamon.main.profile.data.remote.data_source.RemoteProfileDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RemoteDataSourceModule {

    @Binds
    @Singleton
    fun bindsRemoteLoginDataSource(source: RemoteLoginDataSourceImpl): RemoteLoginDataSource

    @Binds
    @Singleton
    fun bindsRemoteImageDataSource(source: RemoteCertificateDataSourceImpl): RemoteCertificateDataSource

    @Binds
    @Singleton
    fun bindsRemoteHomeDataSource(source: RemoteHomeDataSourceImpl): RemoteHomeDataSource

    @Binds
    @Singleton
    fun bindsRemoteProfileDataSource(source: RemoteProfileDataSourceImpl): RemoteProfileDataSource
}
