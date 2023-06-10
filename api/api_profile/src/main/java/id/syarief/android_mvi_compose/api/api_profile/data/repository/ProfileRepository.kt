package id.syarief.android_mvi_compose.api.api_profile.data.repository

import id.syarief.android_mvi_compose.api.api_profile.domain.model.ProfileResponse
import id.syarief.android_mvi_compose.api.api_profile.domain.repository.ProfileRepositoryImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.gson.gson

interface ProfileRepository {
    suspend fun getProfile(profileID: String) : ProfileResponse

    companion object {
        fun create(): ProfileRepository {
            return ProfileRepositoryImpl(
                client = HttpClient(Android) {
                    install(Logging)
                    install(ContentNegotiation) {
                        gson()
                    }
                }
            )
        }
    }
}