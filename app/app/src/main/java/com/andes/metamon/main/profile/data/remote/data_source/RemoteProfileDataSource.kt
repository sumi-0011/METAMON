package com.andes.metamon.main.profile.data.remote.data_source

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.profile.data.remote.model.response.ApiProfileResponse

interface RemoteProfileDataSource {

    suspend fun getProfile(): NetworkState<BaseResponse<ApiProfileResponse?>>
}