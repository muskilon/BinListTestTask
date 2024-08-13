package com.example.binlisttesttask.core.data.database

import android.util.Log
import com.example.binlisttesttask.core.converters.toDomain
import com.example.binlisttesttask.core.converters.toEntity
import com.example.binlisttesttask.core.domain.DatabaseRepository
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.ErrorType
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException

class DatabaseRepositoryImpl(
    private val historyDao: HistoryDao
) : DatabaseRepository {
    override suspend fun saveToHistory(bin: String, card: CardInfo) {
        withContext(Dispatchers.IO) {
            historyDao.insertCard(card.toEntity(bin))
            card.bank?.let { historyDao.insertBank(it.toEntity()) }
            card.country?.let { historyDao.insertCountry(it.toEntity()) }
        }
    }

    override suspend fun getHistory(): Flow<Resource<List<CardInfo>>> = flow {
        val result: Resource<List<CardInfo>> = try {
            val history = historyDao.getHistory()
            if (history.isEmpty()) {
                Resource.Error(ErrorType.EMPTY)
            } else
                Resource.Data(
                    history.map { card ->
                        val bank = card.bank?.let {
                            historyDao.getBank(it).toDomain()
                        }
                        val country = card.country?.let {
                            historyDao.getCountry(it).toDomain()
                        }
                        card.toDomain(bank = bank, country = country)
                    })
        } catch (ex: IOException) {
            Log.e(DB_ERROR_TAG, ex.toString())
            Resource.Error(ErrorType.UNKNOWN_ERROR)
        }
        emit(result)
    }

    companion object {
        private const val DB_ERROR_TAG = "DB_ERROR"
    }
}