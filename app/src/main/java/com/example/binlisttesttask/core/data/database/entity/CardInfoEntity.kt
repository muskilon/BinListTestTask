package com.example.binlisttesttask.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_info")
data class CardInfoEntity(
    @PrimaryKey val bin: String,
    @ColumnInfo(name = "length")
    val length: String?,
    @ColumnInfo(name = "luhn")
    val luhn: String?,
    @ColumnInfo(name = "scheme")
    val scheme: String?,
    @ColumnInfo(name = "type")
    val type: String?,
    @ColumnInfo(name = "brand")
    val brand: String?,
    @ColumnInfo(name = "prepaid")
    val prepaid: String?,
    @ColumnInfo(name = "country")
    val country: String?,
    @ColumnInfo(name = "bank")
    val bank: String?
)