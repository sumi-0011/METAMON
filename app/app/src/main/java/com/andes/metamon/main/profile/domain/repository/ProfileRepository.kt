package com.andes.metamon.main.profile.domain.repository

import com.andes.metamon.main.profile.domain.model.response.ProfileResponse

interface ProfileRepository {
    suspend fun getProfile() : Result<ProfileResponse>
}