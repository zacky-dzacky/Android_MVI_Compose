package id.syarief.android_mvi_compose.module_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import id.syarief.android.mvi_compose.api.api_list.data.api.GithubAPI
import id.syarief.android.mvi_compose.api.api_list.domain.repository.GithubRepositoryImpl
import id.syarief.base.base_component.BaseTheme
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                val viewModel = getViewModel<HomeViewModel>()
                WellnessScreen2(
                    state = viewModel.viewState.value,
                    effectFlow = viewModel.effect,
                    onEventSent = { event ->  viewModel.setEvent(event) },
                    onNavigationRequested = { navigationEffect ->
                        if (navigationEffect is UsersContract.Effect.Navigation.ToRepos) {
//                            navController.navigateToRepos(navigationEffect.userId)
                        }
                    }
                )
            }
        }
    }
}