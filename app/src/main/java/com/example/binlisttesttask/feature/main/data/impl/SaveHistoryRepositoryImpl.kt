package com.example.binlisttesttask.feature.main.data.impl

import com.example.binlisttesttask.core.converters.toEntity
import com.example.binlisttesttask.core.data.database.AppDatabase
import com.example.binlisttesttask.feature.main.domain.repository.SaveHistoryRepository
import com.example.binlisttesttask.core.domain.models.CardInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SaveHistoryRepositoryImpl(
    private val database: AppDatabase
) : SaveHistoryRepository {
    override suspend fun saveToHistory(bin: String, card: CardInfo) {
        withContext(Dispatchers.IO) {
            database.historyDao().insertCard(card.toEntity(bin))
            card.bank?.let { database.historyDao().insertBank(it.toEntity()) }
            card.country?.let { database.historyDao().insertCountry(it.toEntity()) }
        }
    }
}