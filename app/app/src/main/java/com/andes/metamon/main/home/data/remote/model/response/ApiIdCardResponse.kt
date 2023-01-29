package com.andes.metamon.main.home.data.remote.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiIdCardResponse(
    @field:Json(name = "authCardId") val authCardId: Long?,
    @field:Json(name = "nickname") val nickname: String?,
    @field:Json(name = "platform") val platform: String?,
    @field:Json(name = "qrImgUrl") val qrImageUrl: String?,
    @field:Json(name = "profileImgUrl") val profileImageUrl: String?,
    @field:Json(name = "createdAt") val createdAt: String?,
    @field:Json(name = "updatedAt") val updatedAt: String?,
    @field:Json(name = "userId") val userId: Long?,
    @field:Json(name = "userName") val userName: String?,
    @field:Json(name = "userEmail") val userEmail: String?,
    @field:Json(name = "userBirth") val userBirth: String?
)
