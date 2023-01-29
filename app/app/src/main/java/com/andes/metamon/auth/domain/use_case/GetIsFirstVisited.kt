package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.repository.LoginRepository

class GetIsFirstVisited (
    private val repository: LoginRepository
) {

    operator fun invoke(): Boolean {
        return repository.getIsFirstVisited()
    }
}