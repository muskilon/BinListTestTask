package com.example.binlisttesttask.feature.main.data.models

data class CardInfoDto (
    val number: NumberDto? = null,
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: CountryDto?,
    val bank: BankDto?
)