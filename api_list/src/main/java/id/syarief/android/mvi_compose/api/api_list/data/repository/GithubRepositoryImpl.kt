package id.syarief.android.mvi_compose.api.api_list.data.repository

import id.syarief.android.mvi_compose.api.api_list.data.api.GithubAPI
import id.syarief.android.mvi_compose.api.api_list.data.dto.Repo
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.android.mvi_compose.api.api_list.data.dto.UserDetail
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GithubRepositoryImpl(
    private val githubAPI: GithubAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
): GithubRepository {
    override suspend fun getUsers(): Result<List<User>> = makeApiCall(dispatcher) {
        githubAPI.getUsers()
    }

    override suspend fun getUser(userId: String): Result<UserDetail?> = makeApiCall(dispatcher){
        githubAPI.getUser(userId)
    }

    override suspend fun getRepos(userId: String): Result<List<Repo>> = makeApiCall(dispatcher){
        githubAPI.getRepos(userId)
    }
}

suspend fun <T> makeApiCall(
    dispatcher: CoroutineDispatcher,
    call: suspend () -> T
): Result<T> = runCatching {
    withContext(dispatcher) {
        call.invoke()
    }
}