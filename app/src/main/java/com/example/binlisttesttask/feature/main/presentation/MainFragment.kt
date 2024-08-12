package com.example.binlisttesttask.feature.main.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.binlisttesttask.R
import com.example.binlisttesttask.base.BaseFragment
import com.example.binlisttesttask.databinding.FragmentMainBinding
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.core.presentation.State
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private var uri: Uri? = null
    private val viewModel by viewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            viewModel.search(binding.binInput.text.toString())
        }

        binding.historyButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_historyFragment)
        }

        binding.cardInfo.country.setOnClickListener {
            if (uri != null){
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect { state ->
                renderState(state)
            }
        }
    }
    private fun renderState(state: State<CardInfo>) {
        when (state) {
            is State.Default -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is State.Loading -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = true
                binding.error.isVisible = false
            }
            is State.Content<CardInfo> -> {
                setValues(state.content)
                binding.cardInfo.cardSnippet.isVisible = true
                binding.progressBar.isVisible = false
                binding.error.isVisible = false
            }
            is State.Error -> {
                binding.cardInfo.cardSnippet.isVisible = false
                binding.progressBar.isVisible = false
                binding.error.isVisible = true
                binding.error.text = state.errorType.getMessage(requireContext())

            }
        }
    }

    private fun setValues(card: CardInfo) {

        with(binding.cardInfo) {
            card.scheme?.let {
                valueScheme.text = it
            }

            card.type?.let {
                valueType.text = it
            }

            card.brand?.let {
                valueBrand.text = it
            }

            card.prepaid?.let {
                valuePrepaid.text = it
            }

            card.number?.let {
                valueLength.text = it.length
                valueLuhn.text = it.luhn
            }

            card.country?.let {
                val emojiAndName = "${it.emoji}  ${it.name}"
                val coordinates = "latitude: ${it.latitude}\nlongitude: ${it.longitude}"
                emojiAndNameCountry.text = emojiAndName
                coordinatesCountry.text = coordinates
            }

            card.bank?.let {
                nameBank.text = it.name
                urlBank.text = it.url
                phoneBank.text = it.phone
            }
        }
        uri = Uri.parse("geo:0,0?q=${card.country?.latitude},${card.country?.longitude}(${card.country?.name})")
    }
}