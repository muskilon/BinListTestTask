package com.example.binlisttesttask.feature.main.presentation

import com.example.binlisttesttask.feature.main.domain.models.CardInfo

sealed class MainState {
        data object Loading : MainState()
        class Error(val errorType: String) : MainState()
        class Content(val card: CardInfo) : MainState()
}