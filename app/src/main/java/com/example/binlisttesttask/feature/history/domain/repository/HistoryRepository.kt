package com.example.binlisttesttask.feature.history.domain.repository

import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {
    suspend fun getHistory(): Flow<Resource<List<CardInfo>>>
}