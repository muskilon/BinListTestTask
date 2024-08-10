package com.example.binlisttesttask.feature.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.feature.main.domain.models.Resource
import com.example.binlisttesttask.feature.main.domain.usecases.GetCardInfoUseCase
import com.example.binlisttesttask.feature.main.domain.usecases.SaveCardToHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCardInfo: GetCardInfoUseCase,
    private val saveCardToHistory: SaveCardToHistoryUseCase
) : ViewModel() {
    fun search(bin: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getCardInfo.execute(bin).collect{ result ->
                when(result) {
                    is Resource.Data -> {
                        saveCardToHistory.execute(bin, result.value)
                    }
                    is Resource.ConnectionError -> {}
                    is Resource.NotFound -> {}
                }
            }
        }
    }
}