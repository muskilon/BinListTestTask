package com.example.binlisttesttask.feature.main.data.network

import com.example.binlisttesttask.core.domain.models.Resource
import com.example.binlisttesttask.feature.main.data.models.CardInfoDto

interface NetworkClient {
    suspend fun getCardInfo(bin: String): Resource<CardInfoDto>
}