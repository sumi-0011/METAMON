package com.andes.metamon.main.profile.data.repository

import com.andes.metamon.core.data.exception.RetrofitFailureStateException
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.logging.Logger
import com.andes.metamon.main.profile.data.remote.data_source.RemoteProfileDataSource
import com.andes.metamon.main.profile.domain.model.response.ProfileResponse
import com.andes.metamon.main.profile.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val remoteProfileDataSource: RemoteProfileDataSource
) : ProfileRepository {
    override suspend fun getProfile(): Result<ProfileResponse> {
        when (val response = remoteProfileDataSource.getProfile()) {
            is NetworkState.Success -> return Result.success(
                ProfileResponse(
                    userName = response.body.data?.userName.orEmpty(),
                    userEmail = response.body.data?.email.orEmpty()
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
                "${this.javaClass.name}getProfile"
            )
            is NetworkState.UnknownError -> Logger.wtf(
                response.t,
                "${this.javaClass.name}getProfile"
            )
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}
