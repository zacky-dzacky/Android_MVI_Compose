package id.syarief.android_mvi_compose.module_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository

class HomeViewModelFactory(_accountController: GithubRepository) : ViewModelProvider.Factory {
    private val accountController: GithubRepository
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return HomeViewModel(accountController) as T
    }

    init {
        accountController = _accountController
    }
}
