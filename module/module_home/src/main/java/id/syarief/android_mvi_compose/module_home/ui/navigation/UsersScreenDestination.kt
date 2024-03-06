package id.syarief.android_mvi_compose.module_home.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import id.syarief.android_mvi_compose.module_home.ui.feature.users.UsersViewModel
import id.syarief.android_mvi_compose.module_home.ui.feature.users.composable.UsersScreen
import id.syarief.android_mvi_compose.module_home.ui.feature.users.UsersContract
import id.syarief.android_mvi_compose.module_home.di.HomeInstance
import org.koin.androidx.compose.viewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
    HomeInstance.init()
    val vmList: UsersViewModel by viewModel<UsersViewModel>()
    UsersScreen(
        state = vmList.viewState.value,
        effectFlow = vmList.effect,
        onEventSent = { event ->   },
        onNavigationRequested = { navigationEffect ->
            if (navigationEffect is UsersContract.Effect.Navigation.ToDetail) {
                navController.navigateToDetailUser(navigationEffect.userId)
            }
        }
    )
}