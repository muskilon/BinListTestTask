package com.example.binlisttesttask.feature.history.di

import com.example.binlisttesttask.feature.history.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyViewModelModules = module {
    viewModel { HistoryViewModel(getHistory = get()) }
}