package id.syarief.android_mvi_compose.di

import id.syarief.android.mvi_compose.api.api_list.di.repositoryListModule
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module{
    single {
        OkHttpClient.Builder().build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
}
val viewModelModules = module{
    homeViewModelModule
}
val repositoryModules = module{
    repositoryListModule
}

val appModules = listOf(
    appModule,
    repositoryModules
)