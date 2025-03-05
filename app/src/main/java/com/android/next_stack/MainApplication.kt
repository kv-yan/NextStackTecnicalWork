package com.android.next_stack

import android.app.Application
import com.android.next_stack.map.data.di.mapDataModule
import com.android.next_stack.map.domain.di.mapDomainModule
import com.android.next_stack.map.presentation.di.mapPresentationModule
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                mapDataModule,
                mapDomainModule,
                mapPresentationModule
            )
        }
    }
}