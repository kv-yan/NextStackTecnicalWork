package com.android.next_stack.map.domain.di

import com.android.next_stack.map.domain.usecase.GetStationUseCase
import com.android.next_stack.map.domain.usecase.GetStationUseCaseImpl
import com.android.next_stack.map.domain.usecase.GetTidesExtremesUseCase
import com.android.next_stack.map.domain.usecase.GetTidesExtremesUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val mapDomainModule = module {
    singleOf(::GetTidesExtremesUseCaseImpl) { bind<GetTidesExtremesUseCase>() }
    singleOf(::GetStationUseCaseImpl) { bind<GetStationUseCase>() }
}
