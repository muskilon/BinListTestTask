package com.example.binlisttesttask.core.converters

import com.example.binlisttesttask.core.data.database.entity.BankEntity
import com.example.binlisttesttask.core.data.database.entity.CardInfoEntity
import com.example.binlisttesttask.core.data.database.entity.CountryEntity
import com.example.binlisttesttask.feature.main.data.models.BankDto
import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.feature.main.data.models.CountryDto
import com.example.binlisttesttask.feature.main.data.models.NumberDto
import com.example.binlisttesttask.core.domain.models.Bank
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.domain.models.Country
import com.example.binlisttesttask.core.domain.models.Number

fun CardInfoDto.toDomain(): CardInfo? {
    val result = CardInfo(
        number?.toDomain(),
        scheme,
        type,
        brand,
        prepaid?.toYesOrNo(),
        country?.toDomain(),
        bank?.toDomain()
    )
    val anyElementNull = listOf(
        result.number,
        result.scheme,
        result.type,
        result.brand,
        result.prepaid,
        result.country,
        result.bank)
        .any { it != null }
    return if (anyElementNull) result
    else null
}

fun NumberDto.toDomain(): Number? {
    return if (length.isNullOrBlank()) {
        null
    } else {
        Number(
            length,
            luhn?.toYesOrNo()
        )
    }
}

fun CountryDto.toDomain(): Country? {
    return if (numeric.isNullOrEmpty()){
        null
    } else {
        Country(
            numeric,
            alpha2,
            name,
            emoji,
            currency,
            latitude,
            longitude
        )
    }
}

fun BankDto.toDomain(): Bank? {
    return if (name.isNullOrEmpty()) {
        null
    } else {
        Bank(
            name,
            url,
            phone,
            city
        )
    }
}

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

fun CardInfoEntity.toDomain(bank: Bank?, country: Country?) = CardInfo(
    number = Number(
        luhn = luhn,
        length = length
    ),
    bank = bank,
    brand = brand,
    prepaid = prepaid,
    country = country,
    scheme = scheme,
    type = type
)

fun Bank.toEntity() = BankEntity(
    name = name,
    city = city,
    phone = phone,
    url = url
)

fun BankEntity.toDomain() = Bank(
    name = name,
    url = url,
    phone = phone,
    city = city
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

fun CountryEntity.toDomain() = Country(
    numeric = numeric,
    alpha2 = alpha2,
    name = name,
    emoji = emoji,
    currency = currency,
    latitude = latitude,
    longitude = longitude
)

fun Boolean.toYesOrNo(): String {
    return if (this) "Yes"
    else "No"
}