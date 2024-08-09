package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.data.network.BinListAPI
import com.example.binlisttesttask.feature.main.data.network.NetworkClient
import com.example.binlisttesttask.feature.main.data.network.RetrofitNetworkClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val mainDataModules = module {
    single <NetworkClient> { RetrofitNetworkClient(context = androidContext(), binListAPI = get()) }
    single <BinListAPI> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinListAPI::class.java)
    }
}