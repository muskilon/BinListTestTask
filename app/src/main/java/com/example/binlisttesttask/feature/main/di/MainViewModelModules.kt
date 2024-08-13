package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModules = module {
    viewModel { MainViewModel(getCardInfo = get()) }
}