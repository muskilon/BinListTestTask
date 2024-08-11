package com.example.binlisttesttask.feature.main.data.models

class CountryDto (
    val numeric: String,
    val alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Float?    = null,
    val longitude: Float?    = null
)