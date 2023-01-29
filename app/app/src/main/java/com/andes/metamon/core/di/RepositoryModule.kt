package com.andes.metamon.core.di

import com.andes.metamon.auth.data.repository.LoginRepositoryImpl
import com.andes.metamon.auth.domain.repository.LoginRepository
import com.andes.metamon.core.data.repository.CertificateRepositoryImpl
import com.andes.metamon.core.domain.repository.CertificateRepository
import com.andes.metamon.main.home.data.repository.HomeRepositoryImpl
import com.andes.metamon.main.home.domain.repository.HomeRepository
import com.andes.metamon.main.profile.data.repository.ProfileRepositoryImpl
import com.andes.metamon.main.profile.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsLoginRepository(repository: LoginRepositoryImpl): LoginRepository

    @Binds
    @Singleton
    fun bindsImageRepository(repository: CertificateRepositoryImpl): CertificateRepository

    @Binds
    @Singleton
    fun bindsHomeRepository(repository: HomeRepositoryImpl): HomeRepository

    @Binds
    @Singleton
    fun bindsProfileRepository(repository: ProfileRepositoryImpl): ProfileRepository
}
