package com.example.binlisttesttask.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.binlisttesttask.core.data.database.entity.BankEntity
import com.example.binlisttesttask.core.data.database.entity.CardInfoEntity
import com.example.binlisttesttask.core.data.database.entity.CountryEntity

@Database(
    entities = [
        CardInfoEntity::class,
        BankEntity::class,
        CountryEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}