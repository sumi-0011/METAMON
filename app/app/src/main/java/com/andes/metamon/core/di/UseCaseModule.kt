package com.andes.metamon.core.di

import com.andes.metamon.auth.domain.repository.LoginRepository
import com.andes.metamon.auth.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @ViewModelScoped
    @Provides
    fun provideLoginUseCases(repository: LoginRepository): LoginUseCases {
        return LoginUseCases(
            getAccessToken = GetAccessToken(repository),
            saveAccessToken = SaveAccessToken(repository),
            saveUserName = SaveUserName(repository),
            getIsFirstVisited = GetIsFirstVisited(repository),
            setIsFirstVisited = SetIsFirstVisited(repository),
            postLogin = PostLogin(repository)
        )
    }
}