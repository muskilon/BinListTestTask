package com.example.binlisttesttask.feature.main.domain.usecases

import com.example.binlisttesttask.feature.main.domain.MainRepository
import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow

class GetCardInfoUseCase(
    private val repository: MainRepository
) {
    fun execute(bin: String): Flow<Resource<CardInfo>> {
        return repository.getCardInfo(bin)
    }
}