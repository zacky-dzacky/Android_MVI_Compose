package id.syarief.android_mvi_compose

import android.app.Application
import id.syarief.android_mvi_compose.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


data class Person(var name: String?, var age: Int)
class MVIApplicaion: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MVIApplicaion)
            modules(modules = appModules)
        }
    }
}