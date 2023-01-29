package com.andes.metamon.main.profile.data.remote.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiProfileResponse(
    @field:Json(name = "userId") val userId: Long?,
    @field:Json(name = "userName") val userName: String?,
    @field:Json(name = "email") val email: String?,
    @field:Json(name = "userBirth") val userBirth: String?,
)
