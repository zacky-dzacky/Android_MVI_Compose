package id.syarief.android_mvi_compose.module_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.syarief.android_mvi_compose.module_home.di.HomeInstance
import id.syarief.base.base_component.BaseTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeInstance.init()
        setContent {
            val vmList: HomeViewModel by viewModel<HomeViewModel>()
            BaseTheme {
                WellnessScreen2(
                    state = vmList.viewState.value,
                    effectFlow = vmList.effect,
                    onEventSent = { event ->  vmList.setEvent(event) },
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