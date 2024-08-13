package com.example.binlisttesttask.feature.main.data.impl

import com.example.binlisttesttask.core.converters.toDomain
import com.example.binlisttesttask.feature.main.data.network.NetworkClient
import com.example.binlisttesttask.feature.main.domain.repository.MainRepository
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.ErrorType
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepositoryImpl(
    private val networkClient: NetworkClient
) : MainRepository {
    override fun getCardInfo(bin: String): Flow<Resource<CardInfo>> = flow {
        when (val response = networkClient.getCardInfo(bin)) {
            is Resource.Data -> {
                val data = response.value.toDomain()
                if (data != null) {
                    emit(Resource.Data(data))
                } else {
                    emit(Resource.Error(ErrorType.NOT_FOUND))
                }
            }
            is Resource.Error -> emit(Resource.Error(response.error))
        }
    }
}