package com.example.binlisttesttask.feature.main.di

import org.koin.dsl.module

val mainModules = module {
    includes(mainRepositoryModules, mainDataModules, mainViewModelModules, mainUseCasesModules)
}