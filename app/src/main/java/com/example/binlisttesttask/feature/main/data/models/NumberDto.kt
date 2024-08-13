package com.example.binlisttesttask.feature.main.data.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
@Keep
class NumberDto (
    @SerializedName("length")
    val length: String? = null,
    @SerializedName("luhn")
    val luhn: Boolean? = null
)