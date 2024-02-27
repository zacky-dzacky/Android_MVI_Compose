package id.syarief.base.base_api.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }
    single {
        OkHttpClient.Builder()
            .addNetworkInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }
    single {
        GsonConverterFactory.create()
    }
    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .addConverterFactory(get<GsonConverterFactory>())
            .baseUrl("https://api.github.com/")
            .build()
    }
}