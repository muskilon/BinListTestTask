package com.example.binlisttesttask.feature.main.di

import com.example.binlisttesttask.feature.main.data.network.BinListAPI
import com.example.binlisttesttask.feature.main.data.network.NetworkClient
import com.example.binlisttesttask.feature.main.data.network.RetrofitNetworkClient
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single<NetworkClient> { RetrofitNetworkClient(context = androidContext(), binListAPI = get()) }
    single<BinListAPI> {
        Retrofit.Builder()
            .baseUrl("https://lookup.binlist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .build()
            .create(BinListAPI::class.java)
    }
}