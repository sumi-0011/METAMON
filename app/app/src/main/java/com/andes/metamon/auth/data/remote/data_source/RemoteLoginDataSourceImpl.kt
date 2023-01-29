package com.andes.metamon.auth.data.remote.data_source

import com.andes.metamon.auth.data.remote.model.request.ApiLoginRequest
import com.andes.metamon.auth.data.remote.model.response.ApiLoginResponse
import com.andes.metamon.auth.data.remote.service.LoginService
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import javax.inject.Inject

class RemoteLoginDataSourceImpl @Inject constructor(
    private val loginService: LoginService
) : RemoteLoginDataSource {
    override suspend fun postLogin(loginRequest: ApiLoginRequest): NetworkState<BaseResponse<ApiLoginResponse?>> =
        loginService.postLogin(loginRequest)
}
