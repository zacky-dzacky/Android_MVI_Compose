package id.syarief.android_mvi_compose.module_home.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import id.syarief.android_mvi_compose.module_home.ui.feature.detail.DetailUserContract
import id.syarief.android_mvi_compose.module_home.ui.feature.detail.DetailUserViewModel
import id.syarief.android_mvi_compose.module_home.ui.feature.detail.composable.DetailUserScreen
import org.koin.androidx.compose.viewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreenDestination(userDetail: String, navController: NavController) {
    val viewModel: DetailUserViewModel by viewModel<DetailUserViewModel>{ parametersOf(userDetail) }
    DetailUserScreen(
        userID = userDetail,
        onNavigationRequested = {
            if (it is DetailUserContract.Effect.Back) {
                navController.popBackStack()
            }
        }
    )
}