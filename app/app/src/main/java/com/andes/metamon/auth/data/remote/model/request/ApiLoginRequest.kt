package com.andes.metamon.auth.data.remote.model.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiLoginRequest(
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "password") val password: String?
)