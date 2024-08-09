package com.example.binlisttesttask.feature.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.feature.main.domain.usecases.GetCardInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCardInfo: GetCardInfoUseCase
) : ViewModel() {
    fun search(bin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getCardInfo.execute(bin).collect{ result ->
                Log.d("TAG", result.toString())
            }
        }
    }
}