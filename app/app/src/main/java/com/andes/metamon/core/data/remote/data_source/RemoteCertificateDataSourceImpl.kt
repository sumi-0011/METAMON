package com.andes.metamon.core.data.remote.data_source

import com.andes.metamon.auth.data.remote.model.request.ApiCertificateRequest
import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.EmptyResponse
import com.andes.metamon.core.data.remote.service.CertificateService
import javax.inject.Inject

class RemoteCertificateDataSourceImpl @Inject constructor(
    private val certificateService: CertificateService
) : RemoteCertificateDataSource {
    override suspend fun postCertificate(certificateRequest: ApiCertificateRequest): NetworkState<EmptyResponse> {
        return certificateService.postCertificate(certificateRequest)
    }
}