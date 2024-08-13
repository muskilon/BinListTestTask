package com.example.binlisttesttask.core.domain

import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface DatabaseRepository {
    suspend fun getHistory(): Flow<Resource<List<CardInfo>>>
    suspend fun saveToHistory(bin: String, card: CardInfo)
}