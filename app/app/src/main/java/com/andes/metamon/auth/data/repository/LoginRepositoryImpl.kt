package com.andes.metamon.auth.data.repository

import com.andes.metamon.auth.data.remote.data_source.RemoteLoginDataSource
import com.andes.metamon.auth.data.remote.model.request.ApiLoginRequest
import com.andes.metamon.auth.domain.model.request.LoginRequest
import com.andes.metamon.auth.domain.model.response.LoginResponse
import com.andes.metamon.auth.domain.repository.LoginRepository
import com.andes.metamon.core.data.exception.RetrofitFailureStateException
import com.andes.metamon.core.data.local.data_source.LocalPreferenceUserDataSource
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.logging.Logger
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val localPreferenceUserDataSource: LocalPreferenceUserDataSource,
    private val remoteLoginDataSource: RemoteLoginDataSource,
) : LoginRepository {
    override fun getAccessToken(): String {
        return localPreferenceUserDataSource.getAccessToken()
    }

    override fun saveAccessToken(accessToken: String) {
        localPreferenceUserDataSource.saveAccessToken(accessToken)
    }

    override fun saveUserName(userName: String) {
        localPreferenceUserDataSource.saveUserName(userName)
    }

    override fun getIsFirstVisited(): Boolean = localPreferenceUserDataSource.getIsFirstVisited()

    override fun setIsFirstVisited(isFirstVisit: Boolean) {
        localPreferenceUserDataSource.setIsFirstVisited(isFirstVisit)
    }

    override suspend fun postLogin(loginRequest: LoginRequest): Result<LoginResponse> {
        val response = remoteLoginDataSource.postLogin(
            ApiLoginRequest(
                email = loginRequest.email,
                password = loginRequest.password
            )
        )

        when (response) {
            is NetworkState.Success -> return Result.success(
                LoginResponse(
                    id = response.body.data?.id ?: 0L,
                    userName = response.body.data?.userName.orEmpty(),
                    email = response.body.data?.email.orEmpty(),
                    token = response.body.data?.token.orEmpty()
                )
            )
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(
                    response.error,
                    response.code
                )
            )
            is NetworkState.NetworkError -> Logger.wtf(
                response.error,
                "${this.javaClass.name}_postLogin"
            )
            is NetworkState.UnknownError -> Logger.wtf(
                response.t,
                "${this.javaClass.name}_postLogin"
            )
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}
