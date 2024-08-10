package com.example.binlisttesttask.core.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountryEntity(
    @ColumnInfo(name = "country_id")
    @PrimaryKey val numeric: String,
    @ColumnInfo(name = "alpha2")
    val alpha2: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "emoji")
    val emoji: String?,
    @ColumnInfo(name = "currency")
    val currency: String?,
    @ColumnInfo(name = "latitude")
    val latitude: Int?,
    @ColumnInfo(name = "longitude")
    val longitude: Int?
)
