package com.example.binlisttesttask.feature.main.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.feature.main.domain.models.Resource
import com.example.binlisttesttask.feature.main.domain.usecases.GetCardInfoUseCase
import com.example.binlisttesttask.feature.main.domain.usecases.SaveCardToHistoryUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCardInfo: GetCardInfoUseCase,
    private val saveCardToHistory: SaveCardToHistoryUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<MainState>(MainState.Loading)
    val state = _state.asStateFlow()

    fun search(bin: String) {
        _state.update { MainState.Loading }
        viewModelScope.launch(Dispatchers.IO) {
            getCardInfo.execute(bin).collect{ result ->
                when(result) {
                    is Resource.Data -> {
                        saveCardToHistory.execute(bin, result.value)
                        _state.update { MainState.Content(result.value) }
                    }
                    is Resource.ConnectionError -> _state.update { MainState.Error(result.message) }
                    is Resource.NotFound -> _state.update { MainState.Error(result.message) }
                }
            }
        }
    }
}