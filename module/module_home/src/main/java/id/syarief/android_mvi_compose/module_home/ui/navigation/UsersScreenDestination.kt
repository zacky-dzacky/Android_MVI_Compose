package id.syarief.android_mvi_compose.module_home.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import id.syarief.android_mvi_compose.module_home.HomeViewModel
import id.syarief.android_mvi_compose.module_home.RepoScreen
import id.syarief.android_mvi_compose.module_home.UsersContract
import id.syarief.android_mvi_compose.module_home.di.HomeInstance
import org.koin.androidx.compose.viewModel

@Composable
fun UsersScreenDestination(navController: NavController) {
//    HomeInstance.init()
//    val vmList: HomeViewModel by viewModel<HomeViewModel>()
//    FullAppBar(title = "Github User", showBack = true) {
//                        Navigator.navigate(this@HomeActivity, ModuleManifest.ACTIVITY_LOGIN)
//                        finish()
//    }
//    RepoScreen(
//        state = vmList.viewState.value,
//        effectFlow = null,//vmList.effect,
//        onEventSent = { event ->   },
//        onNavigationRequested = { navigationEffect ->
//            if (navigationEffect is UsersContract.Effect.Navigation.ToRepos) {
////                navController.navigateToDetailUser(navigationEffect.userId)
//            }
//        }
//    )
}