package com.andes.metamon.core.di

import com.andes.metamon.core.data.local.data_source.LocalPreferenceUserDataSource
import com.andes.metamon.core.data.local.data_source.LocalPreferenceUserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalDataSourceModule {

    @Binds
    @Singleton
    fun bindsLocalPreferenceUserDataSource(source: LocalPreferenceUserDataSourceImpl): LocalPreferenceUserDataSource
}