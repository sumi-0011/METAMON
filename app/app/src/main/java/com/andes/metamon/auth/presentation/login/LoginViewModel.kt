package com.andes.metamon.auth.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andes.metamon.auth.domain.model.request.LoginRequest
import com.andes.metamon.auth.domain.use_case.LoginUseCases
import com.andes.metamon.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {

    private val _navigateToHome = MutableLiveData<Event<Boolean>>()
    val navigateToHome: LiveData<Event<Boolean>> = _navigateToHome

    private val _loginFailureMessage = MutableLiveData<String>()
    val loginFailureMessage: LiveData<String> = _loginFailureMessage

    fun postLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCases.postLogin(
                LoginRequest(
                    email = email,
                    password = password
                )
            ).onSuccess {
                loginUseCases.saveAccessToken(it.token)
                loginUseCases.saveUserName(it.userName)
                _navigateToHome.postValue(Event(true))
            }.onFailure {
                _loginFailureMessage.postValue(it.message)
            }
        }
    }

    fun getAccessToken(): String =
        loginUseCases.getAccessToken()
}