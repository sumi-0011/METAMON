package com.andes.metamon.core.di

import com.andes.navigator.MainNavigator
import com.andes.metamon.core.navigator.MainNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class NavigatorModule {
    @Binds
    abstract fun provideMainNavigator(
        navigator: MainNavigatorImpl
    ): MainNavigator
}
