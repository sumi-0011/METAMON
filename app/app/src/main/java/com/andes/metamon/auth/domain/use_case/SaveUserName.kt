package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.repository.LoginRepository

class SaveUserName(
    private val repository: LoginRepository
) {

    operator fun invoke(userName: String) {
        repository.saveUserName(userName)
    }
}