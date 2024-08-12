package com.example.binlisttesttask.feature.history.data.impl

import android.util.Log
import com.example.binlisttesttask.core.converters.toDomain
import com.example.binlisttesttask.core.data.database.AppDatabase
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.feature.history.domain.repository.HistoryRepository
import com.example.binlisttesttask.feature.main.domain.models.ErrorType
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class HistoryRepositoryImpl(
    private val database: AppDatabase
) : HistoryRepository {
    override suspend fun getHistory(): Flow<Resource<List<CardInfo>>> = flow {
        val result: Resource<List<CardInfo>> = try {
                val history = database.historyDao().getHistory()
                if (history.isEmpty()) {
                    Resource.Error(ErrorType.NOT_FOUND)
                } else
                    Resource.Data(
                        history.map { card ->
                            val bank = card.bank?.let {
                                database.historyDao().getBank(it).toDomain()
                            }
                            val country = card.country?.let {
                                database.historyDao().getCountry(it).toDomain()
                            }
                            card.toDomain(bank = bank, country = country)
                        })
            } catch (ex: IOException) {
                Log.e("TAG", ex.toString())
                Resource.Error(ErrorType.UNKNOWN_ERROR)
            }
            Log.d("TAG", result.toString())
            emit(result)
        }
}