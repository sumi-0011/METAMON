package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.repository.LoginRepository

class GetAccessToken(
    private val repository: LoginRepository
) {

    operator fun invoke(): String {
        return repository.getAccessToken()
    }
}