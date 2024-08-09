package com.example.binlisttesttask.feature.main.data.network

import android.content.Context
import android.util.Log
import com.example.binlisttesttask.extensions.isConnected
import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class RetrofitNetworkClient(
    private val context: Context,
    private val binListAPI: BinListAPI
) : NetworkClient {
    override suspend fun getCardInfo(bin: String): Resource<CardInfoDto> {
        var cardInfo: Resource<CardInfoDto>
        if (!context.isConnected()) return Resource.ConnectionError(OFFLINE)
        withContext(Dispatchers.IO) {
            cardInfo = try {
                binListAPI.getCardInfo(bin).body()?.let { Resource.Data(it) } ?: Resource.NotFound(NOT_FOUND)
            } catch (ex: IOException) {
                Log.e(REQUEST_ERROR_TAG, ex.toString())
                Resource.ConnectionError(REQUEST_ERROR_TAG)
            }
        }
        return cardInfo
    }

    companion object {
        private const val REQUEST_ERROR_TAG = "Произошла ошибка"
        private const val NOT_FOUND = "not found"
        private const val OFFLINE = "Проверьте подключение к интернету"
    }
}