package com.example.binlisttesttask.feature.main.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class CardInfoDto(
    @SerializedName("number")
    val number: NumberDto? = null,
    @SerializedName("scheme")
    val scheme: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("brand")
    val brand: String? = null,
    @SerializedName("prepaid")
    val prepaid: Boolean? = null,
    @SerializedName("country")
    val country: CountryDto?,
    @SerializedName("bank")
    val bank: BankDto?
)