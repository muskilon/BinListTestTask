package com.example.binlisttesttask.feature.main.presentation

import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.ErrorType

sealed class MainState {
        data object Default : MainState()
        data object Loading : MainState()
        class Error(val errorType: ErrorType) : MainState()
        class Content(val card: CardInfo) : MainState()
}