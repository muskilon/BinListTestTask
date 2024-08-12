package com.example.binlisttesttask.core.presentation

import com.example.binlisttesttask.feature.main.domain.models.ErrorType

sealed class State<T> {
        class Default<T>() : State<T>()
        class Loading<T> : State<T>()
        class Error<T>(val errorType: ErrorType) : State<T>()
        class Content<T>(val content: T) : State<T>()
}