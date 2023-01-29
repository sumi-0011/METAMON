package com.andes.metamon.main.home.data.remote.service

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.home.data.remote.model.response.ApiIdCardResponse
import retrofit2.http.GET

interface IdCardService {

    @GET("v1/auth")
    suspend fun getIdCard(): NetworkState<BaseResponse<List<ApiIdCardResponse>?>>
}