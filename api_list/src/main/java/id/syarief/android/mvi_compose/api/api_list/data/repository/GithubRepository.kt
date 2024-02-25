package id.syarief.android.mvi_compose.api.api_list.data.repository

import id.syarief.android.mvi_compose.api.api_list.data.dto.Repo
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.android.mvi_compose.api.api_list.data.dto.UserDetail

interface GithubRepository {
    suspend fun getUsers(): Result<List<User>>
    suspend fun getUser(userId: String): Result<UserDetail?>
    suspend fun getRepos(userId: String): Result<List<Repo>>
}