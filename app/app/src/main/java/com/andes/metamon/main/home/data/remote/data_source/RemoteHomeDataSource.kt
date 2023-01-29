package com.andes.metamon.main.home.data.remote.data_source

import com.andes.metamon.core.data.remote.call_adapter.NetworkState
import com.andes.metamon.core.data.remote.model.BaseResponse
import com.andes.metamon.main.home.data.remote.model.response.ApiIdCardResponse

interface RemoteHomeDataSource {

    suspend fun getIdCard(): NetworkState<BaseResponse<List<ApiIdCardResponse>?>>
}