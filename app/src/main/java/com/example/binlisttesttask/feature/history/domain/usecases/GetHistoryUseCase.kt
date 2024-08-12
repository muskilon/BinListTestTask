package com.example.binlisttesttask.feature.history.domain.usecases

import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.feature.history.domain.repository.HistoryRepository
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow

class GetHistoryUseCase(
    private val repository: HistoryRepository
) {
    suspend fun execute(): Flow<Resource<List<CardInfo>>> {
        return repository.getHistory()
    }
}