package com.example.binlisttesttask.feature.history.domain.usecases

import com.example.binlisttesttask.core.domain.DatabaseRepository
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.flow.Flow

class GetHistoryUseCase(
    private val repository: DatabaseRepository
) {
    suspend fun execute(): Flow<Resource<List<CardInfo>>> {
        return repository.getHistory()
    }
}