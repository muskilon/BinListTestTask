package com.example.binlisttesttask.feature.main.domain.usecases

import com.example.binlisttesttask.feature.main.domain.repository.SaveHistoryRepository
import com.example.binlisttesttask.core.domain.models.CardInfo

class SaveCardToHistoryUseCase(
    private val repository: SaveHistoryRepository
) {
    suspend fun execute(bin: String, cardInfo: CardInfo) {
        repository.saveToHistory(bin, cardInfo)
    }
}