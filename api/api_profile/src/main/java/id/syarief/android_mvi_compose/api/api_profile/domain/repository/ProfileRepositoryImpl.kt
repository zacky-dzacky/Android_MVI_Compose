package id.syarief.android_mvi_compose.api.api_profile.domain.repository

import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileRepository
import id.syarief.android_mvi_compose.api.api_profile.domain.model.ProfileResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.request.headers
import io.ktor.http.HttpHeaders

class ProfileRepositoryImpl(private val client: HttpClient) : ProfileRepository {

    override suspend fun getProfile(profileID: String) : ProfileResponse{
        return client.get {
            headers {
                append(HttpHeaders.Authorization, "Client-ID")
            }
            url(HttpRoutes.FETCH_IMAGES_URL)
        }.body()
    }

    object HttpRoutes {
        private const val BASE_URL = "https://api.unsplash.com"
        const val FETCH_IMAGES_URL = "${BASE_URL}/photos?page=1"
    }
}