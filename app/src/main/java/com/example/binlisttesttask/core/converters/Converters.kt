package com.example.binlisttesttask.core.converters

import com.example.binlisttesttask.core.data.database.entity.BankEntity
import com.example.binlisttesttask.core.data.database.entity.CardInfoEntity
import com.example.binlisttesttask.core.data.database.entity.CountryEntity
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

fun CardInfo.toEntity(bin: String) = CardInfoEntity(
    bin = bin,
    luhn = number?.luhn,
    length = number?.length,
    bank = bank?.name,
    brand = brand,
    prepaid = prepaid,
    country = country?.numeric,
    scheme = scheme,
    type = type
)

fun Bank.toEntity() = BankEntity(
    name = name,
    city = city,
    phone = phone,
    url = url
)

fun Country.toEntity() = CountryEntity(
    numeric = numeric,
    alpha2 = alpha2,
    name = name,
    emoji = emoji,
    currency = currency,
    latitude = latitude,
    longitude = longitude
)