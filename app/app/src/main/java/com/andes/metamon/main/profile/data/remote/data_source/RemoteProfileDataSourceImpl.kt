package com.andes.metamon.main.profile.data.remote.data_source

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.profile.data.remote.model.response.ApiProfileResponse
import com.andes.metamon.main.profile.data.remote.service.ProfileService
import javax.inject.Inject

class RemoteProfileDataSourceImpl @Inject constructor(
    private val profileService: ProfileService
) : RemoteProfileDataSource {
    override suspend fun getProfile(): NetworkState<BaseResponse<ApiProfileResponse?>> {
        return profileService.getProfile()
    }
}