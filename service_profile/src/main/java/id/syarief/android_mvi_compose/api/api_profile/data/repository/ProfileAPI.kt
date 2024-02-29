package id.syarief.android_mvi_compose.api.api_profile.data.repository

import id.syarief.android_mvi_compose.api.api_profile.data.dto.Profile
import id.syarief.android_mvi_compose.api.api_profile.domain.model.ProfileResponse

import retrofit2.http.GET
import retrofit2.http.Path

interface ProfileAPI {
    @GET("profile/")
    suspend fun getProfile(
        @Path("profileID") profileID: String
    ): ProfileResponse
}