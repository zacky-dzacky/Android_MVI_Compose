package id.syarief.android_mvi_compose.module_home

import androidx.lifecycle.viewModelScope
import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository
import id.syarief.android_mvi_compose.base.BaseViewModel
import kotlinx.coroutines.launch

public class HomeViewModel(
    private val githubRepository: GithubRepository
) : BaseViewModel<UsersContract.Event, UsersContract.State, UsersContract.Effect>() {

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            setState { copy(isLoading = true, isError = false) }

            githubRepository.getUsers()
                .onSuccess { users ->
                    setState { copy(users = users, isLoading = false) }
                    setEffect { UsersContract.Effect.DataWasLoaded }
                }
                .onFailure {
                    setState { copy(isError = true, isLoading = false) }
                }
        }
    }
//    private val getProfileUseCase = GetProfileUseCase()
//    private val _profileState = MutableLiveData<ViewState>()

    fun getProfile() {
//        val profileID = "123456"
//        _profileState.value = ViewState.Loading
//        viewModelScope.launch {
//            when (val response = getProfileUseCase.getProfile(profileID)) {
//                is GetProfileUseCase.Result.SuccessWithData<*> -> {
//                    _profileState.value = ViewState.Success(response.data)
//                }
//                is GetProfileUseCase.Result.Error -> {
//                    _profileState.value = ViewState.Error(response.exception.message ?: "asdf")
//                }
//                else -> {}
//            }
//        }
    }

    override fun setInitialState() = UsersContract.State(
        users = emptyList(),
        isLoading = true,
        isError = false,
    )

    override fun handleEvents(event: UsersContract.Event) {
        when (event) {
            is UsersContract.Event.UserSelection -> setEffect { UsersContract.Effect.Navigation.ToRepos(event.user.userId) }
            is UsersContract.Event.Retry -> getUsers()
        }
    }
}

//sealed class ViewState {
//    object Loading : ViewState()
//    class Success<T>(val data: T) : ViewState()
//    class Error(val message: String) : ViewState()
//}