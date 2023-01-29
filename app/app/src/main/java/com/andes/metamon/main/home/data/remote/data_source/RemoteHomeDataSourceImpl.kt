package com.andes.metamon.main.home.data.remote.data_source

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.home.data.remote.model.response.ApiIdCardResponse
import com.andes.metamon.main.home.data.remote.service.IdCardService
import javax.inject.Inject

class RemoteHomeDataSourceImpl @Inject constructor(
    private val idCardService: IdCardService
) : RemoteHomeDataSource {
    override suspend fun getIdCard(): NetworkState<BaseResponse<List<ApiIdCardResponse>?>> {
        return idCardService.getIdCard()
    }
}