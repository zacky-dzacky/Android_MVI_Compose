package id.syarief.android_mvi_compose.module_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.rememberNavController
import id.syarief.android_mvi_compose.module_home.ui.navigation.HomeNavigation
import id.syarief.base.base_component.BaseTheme

class HomeActivity: ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    HomeNavigation(navController)
                }
            }
        }
    }
}