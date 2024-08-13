package com.example.binlisttesttask.feature.main.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
class CountryDto (
    @SerializedName("numeric")
    val numeric: String? = null,
    @SerializedName("alpha2")
    val domain: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("emoji")
    val emoji: String? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
)