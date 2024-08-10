package com.example.binlisttesttask.feature.main.domain.usecases

import com.example.binlisttesttask.feature.main.domain.SaveHistoryRepository
import com.example.binlisttesttask.feature.main.domain.models.CardInfo

class SaveCardToHistoryUseCase(
    private val repository: SaveHistoryRepository
) {
    suspend fun execute(bin: String, cardInfo: CardInfo) {
        repository.saveToHistory(bin, cardInfo)
    }
}