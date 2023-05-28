package id.syarief.android_mvi_compose

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.main_activity)
        val intent = Intent()
        intent.setClassName(this.packageName,"id.syarief.module.module_home.HomeActivity")
        startActivity(intent)
    }
}