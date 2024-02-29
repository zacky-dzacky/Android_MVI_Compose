package id.syarief.android_mvi_compose.api.api_profile.domain.repository

import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileAPI
import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileRepository
import id.syarief.android_mvi_compose.api.api_profile.domain.model.ProfileResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileRepositoryImpl(
    private val profileAPI: ProfileAPI,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ProfileRepository {

    override suspend fun getProfile(profileID: String) : Result<ProfileResponse> = makeApiCall(dispatcher) {
        profileAPI.getProfile(profileID)
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