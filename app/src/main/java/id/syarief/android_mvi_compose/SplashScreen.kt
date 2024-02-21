package id.syarief.android_mvi_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import id.syarief.base.base_helper.ModuleManifest.ACTIVITY_LOGIN
import id.syarief.base.base_helper.Navigator

class SplashScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        Navigator.navigate(this@SplashScreen, ACTIVITY_LOGIN)
        finish()
    }


}