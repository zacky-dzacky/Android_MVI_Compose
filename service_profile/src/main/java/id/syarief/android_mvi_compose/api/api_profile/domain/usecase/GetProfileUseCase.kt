package id.syarief.android_mvi_compose.api.api_profile.domain.usecase

import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProfileUseCase() {
//    suspend fun getProfile(profileID: String): Result {
//        return withContext(Dispatchers.IO) {
//            try {
//                val result = ProfileRepository.create().getProfile(profileID)
//                Result.SuccessWithData(result)
//            } catch (exception: Exception) {
//                Result.Error(exception)
//            }
//        }
//    }

    sealed class Result {
        class SuccessWithData<T>(val data: T) : Result()
        class Error(val exception: Exception) : Result()
    }
}