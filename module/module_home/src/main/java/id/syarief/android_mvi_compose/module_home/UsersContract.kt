package id.syarief.android_mvi_compose.module_home

import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.android_mvi_compose.base.ViewEvent
import id.syarief.android_mvi_compose.base.ViewSideEffect
import id.syarief.android_mvi_compose.base.ViewState

class UsersContract {
    sealed class Event : ViewEvent {
        object Retry : Event()
        data class UserSelection(val user: User) : Event()
    }

    data class State(
        val users: List<User>,
        val isLoading: Boolean,
        val isError: Boolean,
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()

        sealed class Navigation : Effect() {
            data class ToRepos(val userId: String): Navigation()
        }
    }
}