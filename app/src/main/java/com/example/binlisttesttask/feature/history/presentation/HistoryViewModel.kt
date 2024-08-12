package com.example.binlisttesttask.feature.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.presentation.State
import com.example.binlisttesttask.feature.history.domain.usecases.GetHistoryUseCase
import com.example.binlisttesttask.feature.main.domain.models.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val getHistory: GetHistoryUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<State<List<CardInfo>>>(State.Default())
    val state = _state.asStateFlow()

    fun getHistory() {
        _state.update { State.Loading() }
        viewModelScope.launch(Dispatchers.IO) {
            getHistory.execute().collect { result ->
                when (result) {
                    is Resource.Data -> {
                        _state.update { State.Content(result.value) }
                    }
                    is Resource.Error -> {
                        _state.update { State.Error(result.error) }
                    }
                }
            }
        }
    }
}
