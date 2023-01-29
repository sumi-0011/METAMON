package com.andes.metamon.core.data.remote.data_source

import com.andes.metamon.auth.data.remote.model.request.ApiCertificateRequest
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.EmptyResponse

interface RemoteCertificateDataSource {

    suspend fun postCertificate(certificateRequest: ApiCertificateRequest): NetworkState<EmptyResponse>
}