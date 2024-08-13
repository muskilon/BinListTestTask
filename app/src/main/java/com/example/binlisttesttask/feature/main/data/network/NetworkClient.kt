package com.example.binlisttesttask.feature.main.data.network

import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.core.domain.models.Resource

interface NetworkClient {
    suspend fun getCardInfo(bin: String): Resource<CardInfoDto>
}