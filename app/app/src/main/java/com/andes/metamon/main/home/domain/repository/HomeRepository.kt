package com.andes.metamon.main.home.domain.repository

import com.andes.metamon.main.home.domain.model.response.UserCardInfo

interface HomeRepository {
    fun getUserName(): String
    suspend fun getCards(): Result<List<UserCardInfo>>
}