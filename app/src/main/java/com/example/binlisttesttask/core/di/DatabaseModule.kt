package com.example.binlisttesttask.core.di

import androidx.room.Room
import com.example.binlisttesttask.core.data.database.AppDatabase
import com.example.binlisttesttask.core.data.database.DatabaseRepositoryImpl
import com.example.binlisttesttask.core.domain.DatabaseRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, "query_history.db")
            .build()
    }
    single<DatabaseRepository> {DatabaseRepositoryImpl(historyDao = get<AppDatabase>().historyDao())}
}