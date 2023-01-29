package com.andes.metamon.auth.data.remote.data_source

import com.andes.metamon.auth.data.remote.model.request.ApiLoginRequest
import com.andes.metamon.auth.data.remote.model.response.ApiLoginResponse
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse

interface RemoteLoginDataSource {

    suspend fun postLogin(loginRequest: ApiLoginRequest): NetworkState<BaseResponse<ApiLoginResponse?>>
}
