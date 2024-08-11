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
            is MainState.Loading -> {
                binding.cardInfo.cardSnippet.isVisible = false
            }
            is MainState.Content -> {
                setValues(state.card)
                binding.cardInfo.cardSnippet.isVisible = true
            }
            is MainState.Error -> {}
        }
    }

    private fun setValues(card: CardInfo) {
        with(binding.cardInfo) {
            card.scheme?.let {
                scheme.isVisible = true
                valueScheme.text = it
            } ?: {
                scheme.isVisible = false
            }

            card.type?.let {
                type.isVisible = true
                valueType.text = it
            } ?: {
                type.isVisible = false
            }

            card.brand?.let {
                brand.isVisible = true
                valueBrand.text = it
            } ?: {
                brand.isVisible = false
            }

            card.prepaid?.let {
                prepaid.isVisible = true
                valuePrepaid.text = it
            } ?: {
                prepaid.isVisible = false
            }

            card.number?.let {
                number.isVisible = true
                valueLength.text = it.length
                valueLuhn.text = it.luhn
            } ?: {
                number.isVisible = false
            }

            card.country?.let {
                val emojiAndName = "${it.emoji}  ${it.name}"
                val coordinates = "(latitude: ${it.latitude}, longitude: ${it.longitude})"
                country.isVisible = true
                emojiAndNameCountry.text = emojiAndName
                coordinatesCountry.text = coordinates
            } ?: {
                country.isVisible = false
            }

            card.bank?.let {
                bank.isVisible = true
                nameBank.text = it.name
                urlBank.text = it.url
                phoneBank.text = it.phone
            } ?: {
                bank.isVisible = false
            }


        }
    }
}