package com.example.binlisttesttask.feature.main.data.impl

import com.example.binlisttesttask.core.converters.toDomain
import com.example.binlisttesttask.feature.main.data.network.NetworkClient
import com.example.binlisttesttask.feature.main.data.network.RetrofitNetworkClient
import com.example.binlisttesttask.feature.main.domain.MainRepository
import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val networkClient: NetworkClient
) : MainRepository {
    override fun getCardInfo(bin: String): Flow<Resource<CardInfo>> = flow {
        when (val response = networkClient.getCardInfo(bin)) {
            is Resource.Data -> {
                val data = response.value.toDomain()
                emit(Resource.Data(data))
            }
            is Resource.NotFound -> {}
            is Resource.ConnectionError -> {}
        }
    }
}