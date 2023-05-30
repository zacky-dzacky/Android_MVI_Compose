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
                val intent = Intent()
                intent.setClassName(this.packageName,"id.syarief.android_mvi_compose.module.module_home.HomeActivity")
                startActivity(intent)
                finish()
            }
            alpha.start()
        }
    }


}