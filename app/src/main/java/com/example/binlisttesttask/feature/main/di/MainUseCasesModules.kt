package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.domain.usecases.GetCardInfoUseCase
import org.koin.dsl.module

val mainUseCasesModules = module {
    factory<GetCardInfoUseCase> { GetCardInfoUseCase(repository = get()) }
}