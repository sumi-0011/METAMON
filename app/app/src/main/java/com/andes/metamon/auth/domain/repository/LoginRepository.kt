package com.andes.metamon.auth.domain.repository

import com.andes.metamon.auth.domain.model.request.LoginRequest
import com.andes.metamon.auth.domain.model.response.LoginResponse

interface LoginRepository {

    fun getAccessToken(): String

    fun saveAccessToken(accessToken: String)

    fun saveUserName(userName: String)

    fun getIsFirstVisited(): Boolean

    fun setIsFirstVisited(isFirstVisit: Boolean)

    suspend fun postLogin(loginRequest: LoginRequest): Result<LoginResponse>
}