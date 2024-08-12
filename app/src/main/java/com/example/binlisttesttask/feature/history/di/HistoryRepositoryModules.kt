package com.example.binlisttesttask.feature.history.di

import com.example.binlisttesttask.feature.history.data.impl.HistoryRepositoryImpl
import com.example.binlisttesttask.feature.history.domain.repository.HistoryRepository
import org.koin.dsl.module

val historyRepositoryModules = module {
    single<HistoryRepository> { HistoryRepositoryImpl(database = get()) }
}