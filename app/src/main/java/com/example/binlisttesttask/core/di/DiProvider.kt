package com.example.binlisttesttask.core.di

import com.example.binlisttesttask.feature.history.di.historyUseCasesModules
import com.example.binlisttesttask.feature.history.di.historyViewModelModules
import com.example.binlisttesttask.feature.main.di.networkModules
import com.example.binlisttesttask.feature.main.di.mainRepositoryModules
import com.example.binlisttesttask.feature.main.di.mainUseCasesModules
import com.example.binlisttesttask.feature.main.di.mainViewModelModules

object DiProvider {
    val modules = listOf(
        databaseModule,
        mainRepositoryModules,
        networkModules,
        mainViewModelModules,
        mainUseCasesModules,
        historyViewModelModules,
        historyUseCasesModules
    )
}