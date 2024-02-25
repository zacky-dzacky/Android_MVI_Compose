package id.syarief.android_mvi_compose.module_home

import androidx.compose.runtime.toMutableStateList
import id.syarief.android.mvi_compose.api.api_list.data.dto.User
import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository
import id.syarief.android_mvi_compose.base.BaseViewModel

class WellnessViewModel(
    githubRepository: GithubRepository
): BaseViewModel<UsersContract.Event, UsersContract.State, UsersContract.Effect>() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<User>
        get() = _tasks

    fun remove(item: User){
        _tasks.remove(item)
    }

    fun changeTaskCheced(item: User, checked: Boolean){
//        _tasks.find { it.id == item.id }?.let { task ->
//            task.checked = checked
//        }
    }

    override fun setInitialState(): UsersContract.State {
        TODO("Not yet implemented")
    }

    override fun handleEvents(event: UsersContract.Event) {
        TODO("Not yet implemented")
    }
}

fun getWellnessTasks() = List(30) { i -> User("", "Task # $i")}