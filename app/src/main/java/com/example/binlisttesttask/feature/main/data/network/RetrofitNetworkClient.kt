package com.example.binlisttesttask.feature.main.data.network

import android.content.Context
import android.util.Log
import com.example.binlisttesttask.extensions.isConnected
import com.example.binlisttesttask.feature.main.data.models.CardInfoDto
import com.example.binlisttesttask.core.domain.models.ErrorType
import com.example.binlisttesttask.core.domain.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class RetrofitNetworkClient(
    private val context: Context,
    private val binListAPI: BinListAPI
) : NetworkClient {
    override suspend fun getCardInfo(bin: String): Resource<CardInfoDto> {
        var cardInfo: Resource<CardInfoDto>
        if (!context.isConnected()) return Resource.Error(ErrorType.NO_CONNECTION)
        withContext(Dispatchers.IO) {
            cardInfo = try {
                val response = binListAPI.getCardInfo(bin)
                if (response.body() != null) {
                    Resource.Data(response.body()!!)
                } else {
                    Resource.Error(getErrorType(response.code()))
                }
            } catch (ex: IOException) {
                Log.e(REQUEST_ERROR_TAG, ex.toString())
                Resource.Error(ErrorType.UNKNOWN_ERROR)
            }
        }
        return cardInfo
    }

    private fun getErrorType(code: Int): ErrorType {
        return when {
            (code == REQUEST_LIMIT_CODE) -> ErrorType.REQUEST_LIMIT
            (code >= NOT_FOUND_CODE)-> ErrorType.NOT_FOUND
            else -> ErrorType.UNKNOWN_ERROR
        }
    }

    companion object {
        private const val REQUEST_ERROR_TAG = "REQUEST ERROR"
        private const val REQUEST_LIMIT_CODE = 429
        private const val NOT_FOUND_CODE = 400

    }
}