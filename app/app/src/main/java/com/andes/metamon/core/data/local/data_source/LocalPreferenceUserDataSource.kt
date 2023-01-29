package com.andes.metamon.core.data.local.data_source

interface LocalPreferenceUserDataSource {

    fun getAccessToken(): String

    fun saveAccessToken(accessToken: String)

    fun saveUserName(userName: String)

    fun getUserName(): String

    fun getIsFirstVisited(): Boolean

    fun setIsFirstVisited(isFirstVisited: Boolean)

    fun removeAccessToken()

    fun clearUserInfo()
}
