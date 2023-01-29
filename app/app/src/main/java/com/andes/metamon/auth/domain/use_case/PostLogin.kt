package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.model.request.LoginRequest
import com.andes.metamon.auth.domain.model.response.LoginResponse
import com.andes.metamon.auth.domain.repository.LoginRepository

class PostLogin(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(loginRequest: LoginRequest): Result<LoginResponse> {
        return repository.postLogin(loginRequest)
    }
}