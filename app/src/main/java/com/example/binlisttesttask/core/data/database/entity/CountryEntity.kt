package com.example.binlisttesttask.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @ColumnInfo(name = "country_id")
    @PrimaryKey val numeric: String,
    @ColumnInfo(name = "domain")
    val domain: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "emoji")
    val emoji: String?,
    @ColumnInfo(name = "currency")
    val currency: String?,
    @ColumnInfo(name = "latitude")
    val latitude: String?,
    @ColumnInfo(name = "longitude")
    val longitude: String?
)
