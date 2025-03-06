package com.android.next_stack.map.data.di

import com.android.next_stack.map.data.api.TidesApi
import com.android.next_stack.map.data.mapper.TideMapper
import com.android.next_stack.map.data.repository.StationRepositoryImpl
import com.android.next_stack.map.data.repository.TidesRepositoryImpl
import com.android.next_stack.map.domain.repository.StationRepository
import com.android.next_stack.map.domain.repository.TidesRepository
import com.android.next_stack.map.domain.repository.AstronomyRepository
import com.android.next_stack.map.data.repository.AstronomyRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mapDataModule = module {
    factory<TidesApi> { createTidesApi() }
    singleOf(::TidesRepositoryImpl) { bind<TidesRepository>() }
    singleOf(::StationRepositoryImpl) { bind<StationRepository>() }
    singleOf(::AstronomyRepositoryImpl) { bind<AstronomyRepository>() }
    singleOf(::TideMapper)
}

private fun createTidesApi(): TidesApi {
    return Retrofit.Builder()
        .baseUrl("https://api-dev.tides-chart.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TidesApi::class.java)
}