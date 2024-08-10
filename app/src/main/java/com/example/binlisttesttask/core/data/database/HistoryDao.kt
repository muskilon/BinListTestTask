package com.example.binlisttesttask.core.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.binlisttesttask.core.data.database.entity.BankEntity
import com.example.binlisttesttask.core.data.database.entity.CardInfoEntity
import com.example.binlisttesttask.core.data.database.entity.CountryEntity

@Dao
interface HistoryDao {
    @Query("SELECT * FROM card_info")
    suspend fun getHistory(): List<CardInfoEntity>

    @Query("SELECT * FROM banks WHERE bank_name = :bankName")
    suspend fun getBank(bankName: String): BankEntity

    @Query("SELECT * FROM countries WHERE country_id = :countryId")
    suspend fun getCountry(countryId: Int): CountryEntity

    @Upsert
    suspend fun insertCard(card: CardInfoEntity)

    @Upsert
    suspend fun insertBank(bank: BankEntity)

    @Upsert
    suspend fun insertCountry(country: CountryEntity)
}