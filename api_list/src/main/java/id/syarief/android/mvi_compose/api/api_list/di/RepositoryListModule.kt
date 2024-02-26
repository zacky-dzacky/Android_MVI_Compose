package id.syarief.android.mvi_compose.api.api_list.di

import id.syarief.android.mvi_compose.api.api_list.data.api.GithubAPI
import id.syarief.android.mvi_compose.api.api_list.data.repository.GithubRepository
import id.syarief.android.mvi_compose.api.api_list.domain.repository.GithubRepositoryImpl
import org.koin.dsl.module
import retrofit2.Retrofit

val repositoryListModule = module {

    single {
        get<Retrofit>().create(GithubAPI::class.java)
    }

    factory<GithubRepository> {
        GithubRepositoryImpl(
            githubAPI = get()
        )
    }
}