package id.syarief.android_mvi_compose.api.api_profile.di

import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileAPI
import id.syarief.android_mvi_compose.api.api_profile.data.repository.ProfileRepository
import id.syarief.android_mvi_compose.api.api_profile.domain.repository.ProfileRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceProfileModule = module {
    single {
        get<Retrofit>().create(ProfileAPI::class.java)
    }

    factory<ProfileRepository> {
        ProfileRepositoryImpl(get())
    }
}