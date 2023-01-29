package com.andes.metamon.auth.data.remote.service

import com.andes.metamon.auth.data.remote.model.request.ApiLoginRequest
import com.andes.metamon.auth.data.remote.model.response.ApiLoginResponse
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface LoginService {

    @POST("v1/login")
    suspend fun postLogin(
        @Body body: ApiLoginRequest
    ): NetworkState<BaseResponse<ApiLoginResponse?>>
}