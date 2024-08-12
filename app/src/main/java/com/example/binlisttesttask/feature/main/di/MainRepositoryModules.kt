package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.data.impl.MainRepositoryImpl
import com.example.binlisttesttask.feature.main.data.impl.SaveHistoryRepositoryImpl
import com.example.binlisttesttask.feature.main.domain.repository.MainRepository
import com.example.binlisttesttask.feature.main.domain.repository.SaveHistoryRepository
import org.koin.dsl.module

val mainRepositoryModules = module {
    single<MainRepository> { MainRepositoryImpl(networkClient = get())}
    single<SaveHistoryRepository> { SaveHistoryRepositoryImpl(database = get()) }
}