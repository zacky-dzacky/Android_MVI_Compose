package id.syarief.android.mvi_compose.api.api_list.data.api

import id.syarief.android.mvi_compose.api.api_list.data.api.Endpoints
import id.syarief.android.mvi_compose.api.api_list.data.dto.Repo
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.android.mvi_compose.api.api_list.data.dto.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {
    @GET(Endpoints.GET_USERS)
    suspend fun getUsers(): List<User>

    @GET(Endpoints.GET_USER)
    suspend fun getUser(@Path("userLogin") userId: String): UserDetail?

    @GET(Endpoints.GET_REPOS_BY_USER)
    suspend fun getRepos(@Path("userLogin") userId: String): List<Repo>
}