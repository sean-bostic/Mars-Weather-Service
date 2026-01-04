package org.skunkworks.project.di


import kotlinx.serialization.json.Json
import org.koin.dsl.module
import org.skunkworks.project.data.remote.api.MarsWeatherApi
import org.skunkworks.project.data.remote.createHttpClient
import org.skunkworks.project.presentation.screens.soldetail.SolDetailViewModel
import org.skunkworks.project.presentation.screens.sollist.SolListViewModel
import org.skunkworks.project.data.repository.MarsWeatherRepositoryImpl
import org.skunkworks.project.domain.repository.MarsWeatherRepository
import org.skunkworks.project.domain.usecase.GetLatestSolsUseCase

val appModule = module {
    // Json
    single {
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }
    }

    // Ktor Client
    single { createHttpClient() }

    // API
    single { MarsWeatherApi(get()) }

    // Repository
    single<MarsWeatherRepository> { MarsWeatherRepositoryImpl(get(), get()) }

    // Use Cases
    factory { GetLatestSolsUseCase(get()) }

    // ViewModels
    single { SolListViewModel(get()) }
    single { SolDetailViewModel() }
}