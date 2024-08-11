package com.example.binlisttesttask.feature.main.domain.models

data class CardInfo (
    val number: Number? = Number(),
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: String? = null,
    val country: Country? = null,
    val bank: Bank? = null
)