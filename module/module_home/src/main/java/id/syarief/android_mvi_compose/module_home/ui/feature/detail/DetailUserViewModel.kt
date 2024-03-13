package id.syarief.android_mvi_compose.module_home.ui.feature.detail

import androidx.lifecycle.viewModelScope
import id.syarief.android.mvi_compose.api.api_list.data.dto.UserDetail
import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository
import id.syarief.android_mvi_compose.base.BaseViewModel
import kotlinx.coroutines.launch

class DetailUserViewModel(
    private val userID: String,
    private val githubRepository: GithubRepository
) : BaseViewModel<DetailUserContract.Event, DetailUserContract.State, DetailUserContract.Effect>() {

    init {
        getDetailUsers(userID)
    }

    private fun syncData() {
//        viewModelScope.launch {
//            getDetailUsers(userID)
//        }
    }
    fun getDetailUsers(userID: String) {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }
            githubRepository.getUser(userID)
                .onSuccess {  user ->
                    setState { copy(user = user ?: UserDetail(), isLoading = false) }
                    setEffect { DetailUserContract.Effect.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }

    override fun setInitialState() =  DetailUserContract.State (
        user = UserDetail(),
        isLoading = true,
        isError = false

    )

    override fun handleEvents(event: DetailUserContract.Event) {
        when (event) {
            is DetailUserContract.Event.Retry -> getDetailUsers(userID)
        }
    }

}