package id.syarief.android_mvi_compose.module_home.ui.feature.users.composable

import androidx.compose.runtime.Composable
import id.syarief.android_mvi_compose.module_home.ui.feature.detail.DetailUserContract
import id.syarief.base.base_component.FullAppBar

@Composable
fun DetailUserScreen(
    onNavigationRequested: (navigationEffect: DetailUserContract.Effect.Back) -> Unit
) {
    FullAppBar(title = "Detail User") {
        onNavigationRequested(DetailUserContract.Effect.Back)
    }
}