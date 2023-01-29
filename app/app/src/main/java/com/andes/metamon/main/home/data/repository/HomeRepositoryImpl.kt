package com.andes.metamon.main.home.data.repository

import com.andes.metamon.core.data.exception.RetrofitFailureStateException
import com.andes.metamon.core.data.local.data_source.LocalPreferenceUserDataSource
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.logging.Logger
import com.andes.metamon.main.home.data.remote.data_source.RemoteHomeDataSource
import com.andes.metamon.main.home.domain.model.response.UserCardInfo
import com.andes.metamon.main.home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val localPreferenceUserDataSource: LocalPreferenceUserDataSource,
    private val remoteHomeDataSource: RemoteHomeDataSource
) : HomeRepository {
    override fun getUserName(): String {
        return localPreferenceUserDataSource.getUserName()
    }

    override suspend fun getCards(): Result<List<UserCardInfo>> {
        when (val idCardList = remoteHomeDataSource.getIdCard()) {
            is NetworkState.Success -> return Result.success(
                idCardList.body.data?.map {
                    UserCardInfo(
                        authCardId = it.authCardId ?: 0L,
                        nickname = it.nickname.orEmpty(),
                        platform = it.platform.orEmpty(),
                        qrImageUrl = it.qrImageUrl.orEmpty(),
                        profileImageUrl = it.profileImageUrl.orEmpty(),
                        userId = it.userId ?: 0L,
                        userName = it.userName.orEmpty(),
                        userEmail = it.userEmail.orEmpty(),
                        userBirth = it.userBirth.orEmpty()
                    )
                } ?: emptyList()
            )
            is NetworkState.Failure -> return Result.failure(
                RetrofitFailureStateException(
                    idCardList.error,
                    idCardList.code
                )
            )
            is NetworkState.NetworkError -> Logger.wtf(
                idCardList.error,
                "${this.javaClass.name}_postLogin"
            )
            is NetworkState.UnknownError -> Logger.wtf(
                idCardList.t,
                "${this.javaClass.name}_postLogin"
            )
        }
        return Result.failure(IllegalStateException("NetworkError or UnKnownError please check timber"))
    }
}