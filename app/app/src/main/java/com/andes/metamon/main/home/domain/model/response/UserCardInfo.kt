package com.andes.metamon.main.home.domain.model.response

data class UserCardInfo(
    val authCardId: Long,
    val nickname: String,
    val platform: String,
    val qrImageUrl: String,
    val profileImageUrl: String,
    val userId: Long,
    val userName: String,
    val userEmail: String,
    val userBirth: String
)