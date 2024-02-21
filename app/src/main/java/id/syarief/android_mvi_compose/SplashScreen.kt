package id.syarief.android_mvi_compose

import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import id.syarief.base.base_helper.ModuleManifest
import id.syarief.base.base_helper.ModuleManifest.ACTIVITY_HOME
import id.syarief.base.base_helper.ModuleManifest.ACTIVITY_LOGIN
import id.syarief.base.base_helper.Navigator

class SplashScreen : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        splashScreen.setOnExitAnimationListener { splashScreenView ->
            val alpha = ObjectAnimator.ofFloat(
                splashScreenView.view,
                View.ALPHA,
                1f,
                0f
            )
            alpha.duration = 800L
            alpha.doOnEnd {
                splashScreenView.remove()
                Navigator.navigate(this@SplashScreen, ACTIVITY_LOGIN)
                finish()
            }
            alpha.start()
        }
    }


}