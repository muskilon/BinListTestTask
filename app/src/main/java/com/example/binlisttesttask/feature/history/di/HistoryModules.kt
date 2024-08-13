package com.example.binlisttesttask.feature.history.di

import org.koin.dsl.module

val historyModules = module {
    includes(historyViewModelModules, historyUseCasesModules)
}