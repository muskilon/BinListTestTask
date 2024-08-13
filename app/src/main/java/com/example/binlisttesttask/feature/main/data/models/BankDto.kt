package com.example.binlisttesttask.feature.main.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class BankDto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("city")
    val city: String? = null
)