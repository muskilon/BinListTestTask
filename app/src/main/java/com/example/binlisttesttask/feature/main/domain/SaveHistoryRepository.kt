package com.example.binlisttesttask.feature.main.domain

import com.example.binlisttesttask.feature.main.domain.models.CardInfo

interface SaveHistoryRepository {
    suspend fun saveToHistory(bin: String, card: CardInfo)
}