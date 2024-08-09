package com.example.binlisttesttask.feature.main.data.network

import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.feature.main.domain.models.Resource
import okhttp3.Response

interface NetworkClient {
    suspend fun getCardInfo(bin: String): Resource<CardInfoDto>
}