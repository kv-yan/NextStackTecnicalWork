package com.android.next_stack.map.presentation.di

import com.android.next_stack.map.presentation.StationViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val mapPresentationModule = module {
    viewModelOf(::StationViewModel)
}