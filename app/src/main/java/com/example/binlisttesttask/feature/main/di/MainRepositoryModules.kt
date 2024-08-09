package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.data.impl.MainRepositoryImpl
import com.example.binlisttesttask.feature.main.domain.MainRepository
import org.koin.dsl.module

val mainRepositoryModules = module {
    single<MainRepository> { MainRepositoryImpl(networkClient = get())}
}