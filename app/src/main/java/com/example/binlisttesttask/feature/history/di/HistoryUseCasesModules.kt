package com.example.binlisttesttask.feature.history.di

import com.example.binlisttesttask.feature.history.domain.usecases.GetHistoryUseCase
import org.koin.dsl.module

val historyUseCasesModules = module {
    factory<GetHistoryUseCase> { GetHistoryUseCase(repository = get()) }
}