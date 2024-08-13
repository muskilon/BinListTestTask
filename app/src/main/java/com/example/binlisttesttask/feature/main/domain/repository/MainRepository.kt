package com.example.binlisttesttask.feature.main.domain.repository

import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getCardInfo(bin: String): Flow<Resource<CardInfo>>
}