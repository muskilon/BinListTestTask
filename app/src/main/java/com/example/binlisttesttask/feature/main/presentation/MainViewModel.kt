package com.example.binlisttesttask.feature.main.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.presentation.State
import com.example.binlisttesttask.core.domain.models.Resource
import com.example.binlisttesttask.feature.main.domain.usecases.GetCardInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val getCardInfo: GetCardInfoUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<State<CardInfo>>(State.Default())
    val state = _state.asStateFlow()

    fun search(bin: String) {
        _state.update { State.Loading() }
        viewModelScope.launch(Dispatchers.IO) {
            getCardInfo.execute(bin).collect{ result ->
                when(result) {
                    is Resource.Data -> {
                        _state.update { State.Content(result.value) }
                    }
                    is Resource.Error -> _state.update { State.Error(result.error) }
                }
            }
        }
    }
}