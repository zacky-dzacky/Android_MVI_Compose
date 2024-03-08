package id.syarief.android_mvi_compose.module_home.ui.feature.detail

import id.syarief.android.mvi_compose.api.api_list.data.dto.UserDetail
import id.syarief.android_mvi_compose.base.ViewEvent
import id.syarief.android_mvi_compose.base.ViewSideEffect
import id.syarief.android_mvi_compose.base.ViewState

class DetailUserContract {
    sealed class Event : ViewEvent {
        object Retry : Event()
    }

    data class State(
        val user: UserDetail,
        val isLoading: Boolean,
        val isError: Boolean
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        object DataWasLoaded : Effect()

        object Back: Navigation()

        sealed class Navigation : Effect() {
            data class ToRepos(val userId: String): Navigation()
        }
    }
}