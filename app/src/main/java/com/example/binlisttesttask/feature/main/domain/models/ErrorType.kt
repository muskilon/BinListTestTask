package com.example.binlisttesttask.feature.main.domain.models

import android.content.Context
import com.example.binlisttesttask.R

enum class ErrorType(private val message: Int) {
    NO_CONNECTION(R.string.check_connection),
    REQUEST_LIMIT(R.string.limit_exceeded),
    NOT_FOUND(R.string.not_found),
    UNKNOWN_ERROR(R.string.unknown_error);

    fun getMessage(context: Context) =
        context.getString(message)
}