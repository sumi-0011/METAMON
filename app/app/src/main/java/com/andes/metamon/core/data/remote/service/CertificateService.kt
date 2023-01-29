package com.andes.metamon.core.data.remote.service

import com.andes.metamon.auth.data.remote.model.request.ApiCertificateRequest
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.EmptyResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CertificateService {

    @POST("v1/auth")
    suspend fun postCertificate(
        @Body body: ApiCertificateRequest
    ): NetworkState<EmptyResponse>
}