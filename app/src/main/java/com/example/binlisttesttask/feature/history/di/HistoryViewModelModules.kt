package com.example.binlisttesttask.feature.history.di

import com.example.binlisttesttask.feature.history.presentation.HistoryViewModel
import com.example.binlisttesttask.feature.main.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyViewModelModules = module {
    viewModel { HistoryViewModel(getHistory = get())}
}