package com.andes.metamon.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andes.metamon.core.domain.model.CertificateRequest
import com.andes.metamon.core.domain.repository.CertificateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val certificateRepository: CertificateRepository
): ViewModel() {

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String> = _imageUrl

    fun postCertificate(
        platform: String,
        nickname: String
    ) {
        viewModelScope.launch {
            certificateRepository.postCertificate(
                CertificateRequest(
                    platform = platform,
                    nickname = nickname,
                    imageUrl = imageUrl.value.orEmpty()
                )
            ).onSuccess {
                Log.d("okhttp", "새로운 플랫폼 등록 성공")
            }.onFailure {
                Log.d("okhttp", "새로운 플랫폼 등록 실패")
            }
        }
    }

    fun uploadAndDownloadFile(
        folderName: String,
        userId: Long,
        fileName: String,
        file: File
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            certificateRepository.uploadAndDownloadFile(
                folderName,
                userId,
                fileName,
                file
            ) {
                if (it.isNotEmpty()) _imageUrl.postValue(it)
            }
        }
    }
}