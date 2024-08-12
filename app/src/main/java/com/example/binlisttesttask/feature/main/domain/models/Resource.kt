package com.example.binlisttesttask.feature.main.domain.models

sealed interface Resource<T> {
    data class Data<T>(val value: T) : Resource<T>
    data class Error<T>(val error: ErrorType) : Resource<T>
}