package com.example.binlisttesttask.feature.main.data.models

data class CardInfoDto (
    val number: NumberDto? = NumberDto(),
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: CountryDto? = CountryDto(),
    val bank: BankDto? = BankDto()
)