package id.syarief.android_mvi_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import id.syarief.android_mvi_compose.ui.home.Home
import id.syarief.base.base_component.BaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaseTheme {
                Home()
            }
        }
    }
}