package com.example.binlisttesttask.core.converters

import com.example.binlisttesttask.feature.main.data.models.BankDto
import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.feature.main.data.models.CountryDto
import com.example.binlisttesttask.feature.main.data.models.NumberDto
import com.example.binlisttesttask.feature.main.domain.models.Bank
import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import com.example.binlisttesttask.feature.main.domain.models.Country
import com.example.binlisttesttask.feature.main.domain.models.Number

fun CardInfoDto.toDomain() = CardInfo(
    number?.toDomain(),
    scheme,
    type,
    brand,
    prepaid,
    country?.toDomain(),
    bank?.toDomain(),
)

fun NumberDto.toDomain() = Number(
    length,
    luhn
)

fun CountryDto.toDomain() = Country(
    numeric,
    alpha2,
    name,
    emoji,
    currency,
    latitude,
    longitude
)

fun BankDto.toDomain() = Bank(
    name,
    url,
    phone,
    city
)