package com.example.binlisttesttask.feature.main.domain.usecases

import com.example.binlisttesttask.core.domain.DatabaseRepository
import com.example.binlisttesttask.core.domain.models.CardInfo

class SaveCardToHistoryUseCase(
    private val repository: DatabaseRepository
) {
    suspend fun execute(bin: String, cardInfo: CardInfo) {
        repository.saveToHistory(bin, cardInfo)
    }
}