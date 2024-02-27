package id.syarief.android_mvi_compose.module_home.di

import org.koin.core.context.loadKoinModules

object HomeInstance {
    private val loadModules by lazy {
        loadKoinModules(homeViewModelModule)
    }

    fun init() = loadModules
}
