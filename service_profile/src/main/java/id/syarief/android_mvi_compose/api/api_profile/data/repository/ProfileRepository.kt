package id.syarief.android_mvi_compose.api.api_profile.data.repository

import id.syarief.android_mvi_compose.api.api_profile.domain.model.ProfileResponse

interface ProfileRepository {
    suspend fun getProfile(profileID: String) : Result<ProfileResponse>
}