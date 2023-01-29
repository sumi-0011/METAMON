package com.andes.metamon.core.domain.model

data class CertificateRequest(
    val platform: String,
    val nickname: String,
    val imageUrl: String
)