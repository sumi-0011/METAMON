package com.andes.metamon.auth.domain.use_case

import com.andes.metamon.auth.domain.repository.LoginRepository

class SetIsFirstVisited(
    private val repository: LoginRepository
) {

    operator fun invoke(isFirstVisit: Boolean) {
        repository.setIsFirstVisited(isFirstVisit)
    }
}