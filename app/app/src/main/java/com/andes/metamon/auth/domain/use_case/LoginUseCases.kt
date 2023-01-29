package com.andes.metamon.auth.domain.use_case

data class LoginUseCases(
    val getAccessToken: GetAccessToken,
    val saveAccessToken: SaveAccessToken,
    val saveUserName: SaveUserName,
    val getIsFirstVisited: GetIsFirstVisited,
    val setIsFirstVisited: SetIsFirstVisited,
    val postLogin: PostLogin
)