package com.andes.metamon.main.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andes.metamon.logging.Logger
import com.andes.metamon.main.home.domain.model.response.UserCardInfo
import com.andes.metamon.main.home.domain.repository.HomeRepository
import com.andes.metamon.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _homeUiState: MutableStateFlow<UiState<List<UserCardInfo>>> =
        MutableStateFlow(UiState.Loading)
    val homeUiState: StateFlow<UiState<List<UserCardInfo>>>
        get() = _homeUiState.asStateFlow()

    fun getUserName(): String {
        return homeRepository.getUserName()
    }

    fun getCards() {
        viewModelScope.launch {
            _homeUiState.value = UiState.Loading
            homeRepository.getCards()
                .onSuccess {
                    _homeUiState.value = UiState.Success(it)
                    Logger.d("getCards Success!")
                }
                .onFailure {
                    _homeUiState.value = UiState.Failure(it.message)
                    Logger.d("getCards Failure!")
                }
        }
    }
}