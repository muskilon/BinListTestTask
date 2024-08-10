package com.example.binlisttesttask.feature.main.domain.models

class Country (
    val numeric: String,
    val alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Int?    = null,
    val longitude: Int?    = null
)