package com.andes.metamon.core.data.remote.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EmptyResponse(
    @field:Json(name = "status") val status: Int,
    @field:Json(name = "message") val message: String
)