package com.example.binlisttesttask.core.presentation

import android.app.Application
import com.example.binlisttesttask.core.di.databaseModule
import com.example.binlisttesttask.feature.main.di.mainDataModules
import com.example.binlisttesttask.feature.main.di.mainModules
import com.example.binlisttesttask.feature.main.di.mainRepositoryModules
import com.example.binlisttesttask.feature.main.di.mainUseCasesModules
import com.example.binlisttesttask.feature.main.di.mainViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(mainModules, databaseModule)
        }
    }
}