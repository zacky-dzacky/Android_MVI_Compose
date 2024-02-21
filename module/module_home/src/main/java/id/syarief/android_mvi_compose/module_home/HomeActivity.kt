package id.syarief.android_mvi_compose.module_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.syarief.base.base_component.BaseTheme

class HomeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Home()
            }
        }
    }
}