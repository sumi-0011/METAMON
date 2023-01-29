package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.repository.LoginRepository

class SaveAccessToken(
    private val repository: LoginRepository
) {

    operator fun invoke(accessToken: String) {
        repository.saveAccessToken(accessToken)
    }
}