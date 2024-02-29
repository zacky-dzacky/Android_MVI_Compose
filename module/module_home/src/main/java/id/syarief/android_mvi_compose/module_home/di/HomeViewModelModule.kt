package id.syarief.android_mvi_compose.module_home.di

import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository
import id.syarief.android_mvi_compose.module_home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {

    viewModel {
        HomeViewModel(get<GithubRepository>())
    }
}