package id.syarief.base.base_api

import io.ktor.client.HttpClient

object APIClient {
    private const val AUTHORIZATION_HEADER = "Authorization"
    private var API_KEY: String = "Your API Key here"
    const val ENDPOINT = "https://api.github.com/"
}