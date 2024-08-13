package com.example.binlisttesttask.feature.history.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.binlisttesttask.base.BaseFragment
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.presentation.State
import com.example.binlisttesttask.databinding.FragmentHistoryBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(FragmentHistoryBinding::inflate) {
    private val historyAdapter = HistoryAdapter()
    private val viewModel by viewModel<HistoryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.historyRv.adapter = historyAdapter

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                renderState(state)
            }
        }
        viewModel.getHistory()
    }

    private fun renderState(state: State<List<CardInfo>>) {
        when (state) {
            is State.Default -> {
                binding.historyRv.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is State.Loading -> {
                binding.historyRv.isVisible = false
                binding.progressBar.isVisible = true
                binding.error.isVisible = false
            }
            is State.Content<List<CardInfo>> -> {
                historyAdapter.setData(state.content)
                binding.historyRv.isVisible = true
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is State.Error -> {
                binding.historyRv.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = true
                binding.error.text = state.errorType.getMessage(requireContext())
            }
        }
    }
}