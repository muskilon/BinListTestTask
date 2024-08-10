package com.example.binlisttesttask.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "banks")
data class BankEntity(
    @ColumnInfo(name = "bank_name")
    @PrimaryKey val name: String,
    @ColumnInfo(name = "url")
    val url: String?,
    @ColumnInfo(name = "phone")
    val phone: String?,
    @ColumnInfo(name = "city")
    val city: String?
)
