package com.andes.metamon.main.profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andes.metamon.logging.Logger
import com.andes.metamon.main.profile.domain.model.response.ProfileResponse
import com.andes.metamon.main.profile.domain.repository.ProfileRepository
import com.andes.metamon.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val _profileUiState: MutableStateFlow<UiState<ProfileResponse>> =
        MutableStateFlow(UiState.Loading)
    val homeUiState: StateFlow<UiState<ProfileResponse>>
        get() = _profileUiState.asStateFlow()

    fun getProfile() {
        viewModelScope.launch {
            _profileUiState.value = UiState.Loading
            profileRepository.getProfile()
                .onSuccess {
                    _profileUiState.value = UiState.Success(it)
                    Logger.d("getProfile Success!")
                }
                .onFailure {
                    _profileUiState.value = UiState.Failure(it.message)
                    Logger.d("getProfile Failure!")
                }
        }
    }
}