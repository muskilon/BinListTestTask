package com.example.binlisttesttask.feature.main.domain

import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getCardInfo(bin: String): Flow<Resource<CardInfo>>
}