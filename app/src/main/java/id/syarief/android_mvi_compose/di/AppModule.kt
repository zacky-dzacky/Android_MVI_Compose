package id.syarief.android_mvi_compose.di

import id.syarief.android.mvi_compose.api.api_list.di.repositoryListModule
import id.syarief.android_mvi_compose.api.api_profile.di.serviceProfileModule
import id.syarief.base.base_api.di.networkModule

val appModules = listOf(
    networkModule,
    repositoryListModule,
    serviceProfileModule
)