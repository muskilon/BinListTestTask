package com.example.binlisttesttask.feature.main.domain.repository

import com.example.binlisttesttask.core.domain.models.CardInfo

interface SaveHistoryRepository {
    suspend fun saveToHistory(bin: String, card: CardInfo)
}