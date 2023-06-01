package id.syarief.base.base_api

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.request.header

object APIClient {
    private const val AUTHORIZATION_HEADER = "Authorization"
    private var API_KEY: String = "Your API Key here"
    private val client = HttpClient(Android) {
//        defaultRequest {
//            header(AUTHORIZATION_HEADER, API_KEY)
//        }
//        install(JsonFeature) {
//            serializer = KotlinxSerializer(
//                kotlinx.serialization.json.Json {
//                    isLenient = true
//                    ignoreUnknownKeys = true
//                    explicitNulls = false
//                }
//            )
//        }

    }

    val getInstance = client
}