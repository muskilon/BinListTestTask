package com.example.binlisttesttask.feature.main.domain.usecases

import com.example.binlisttesttask.feature.main.domain.repository.MainRepository
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.flow.Flow

class GetCardInfoUseCase(
    private val repository: MainRepository
) {
    fun execute(bin: String): Flow<Resource<CardInfo>> {
        return repository.getCardInfo(bin)
    }
}