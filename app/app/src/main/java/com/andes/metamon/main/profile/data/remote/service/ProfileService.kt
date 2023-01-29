package com.andes.metamon.main.profile.data.remote.service

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.profile.data.remote.model.response.ApiProfileResponse
import retrofit2.http.GET

interface ProfileService {

    @GET("v1/users/me")
    suspend fun getProfile(): NetworkState<BaseResponse<ApiProfileResponse?>>
}