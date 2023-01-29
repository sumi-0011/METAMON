package com.andes.metamon.auth.data.remote.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCertificateRequest(
    @field:Json(name = "platform") val platform: String?,
    @field:Json(name = "nickname") val nickname: String?,
    @field:Json(name = "imgUrl") val imageUrl: String?
)