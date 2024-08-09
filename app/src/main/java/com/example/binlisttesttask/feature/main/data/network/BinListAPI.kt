package com.example.binlisttesttask.feature.main.data.network

import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface BinListAPI {
    @GET("{bin}")
    suspend fun getCardInfo(
        @Path("bin") bin: String
    ): Response<CardInfoDto>
}