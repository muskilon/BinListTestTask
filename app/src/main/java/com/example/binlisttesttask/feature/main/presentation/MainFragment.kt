package com.example.binlisttesttask.feature.main.presentation

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.binlisttesttask.base.BaseFragment
import com.example.binlisttesttask.databinding.FragmentMainBinding
import com.example.binlisttesttask.feature.main.domain.models.CardInfo
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel by viewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            viewModel.search(binding.binInput.text.toString())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                renderState(state)
            }
        }
    }
    private fun renderState(state: MainState) {
        when (state) {
            is MainState.Default -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is MainState.Loading -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = true
                binding.error.isVisible = false
            }
            is MainState.Content -> {
                setValues(state.card)
                binding.cardInfo.cardSnippet.isVisible = true
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is MainState.Error -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = true
                binding.error.text = state.errorType.getMessage(requireContext())

            }
        }
    }

    private fun setValues(card: CardInfo) {

        with(binding.cardInfo) {
            scheme.isVisible = card.scheme != null
            valueScheme.text = card.scheme

            type.isVisible = card.type != null
            valueType.text = card.type

            brand.isVisible = card.brand != null
            valueBrand.text = card.brand

            prepaid.isVisible = card.prepaid != null
            valuePrepaid.text = card.prepaid

            number.isVisible = card.number != null
            card.number?.let {
                valueLength.text = it.length
                valueLuhn.text = it.luhn
            }

            country.isVisible = card.country != null
            card.country?.let {
                val emojiAndName = "${it.emoji}  ${it.name}"
                val coordinates = "(latitude: ${it.latitude}, longitude: ${it.longitude})"
                emojiAndNameCountry.text = emojiAndName
                coordinatesCountry.text = coordinates
            }

            bank.isVisible = card.bank != null
            card.bank?.let {
                nameBank.text = it.name
                urlBank.text = it.url
                phoneBank.text = it.phone
            }
        }
    }
}