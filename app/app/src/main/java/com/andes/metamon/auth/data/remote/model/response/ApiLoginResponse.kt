package com.andes.metamon.auth.data.remote.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiLoginResponse(
    @field:Json(name = "id") val id: Long?,
    @field:Json(name = "userName") val userName: String?,
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "token") val token: String?
)