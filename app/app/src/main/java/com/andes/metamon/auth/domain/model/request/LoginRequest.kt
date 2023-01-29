package com.andes.metamon.auth.domain.model.request

data class LoginRequest(
    val email: String,
    val password: String
)