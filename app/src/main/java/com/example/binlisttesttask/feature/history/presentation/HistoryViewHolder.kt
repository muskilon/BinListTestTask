package com.example.binlisttesttask.feature.history.presentation

import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.databinding.CardInfoSnippetBinding
import com.example.binlisttesttask.core.domain.models.CardInfo

class HistoryViewHolder(
    private val binding: CardInfoSnippetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: CardInfo) {
        with(binding) {
            model.scheme?.let {
                valueScheme.text = it
            }
            model.type?.let {
                valueType.text = it
            }
            model.brand?.let {
                valueBrand.text = it
            }
            model.prepaid?.let {
                valuePrepaid.text = it
            }
            model.number?.length?.let {
                valueLength.text = it
            }
            model.number?.luhn?.let {
                valueLuhn.text = it
            }
            model.country?.let {
                val emojiAndName = "${it.emoji}  ${it.name}"
                val coordinates = "latitude: ${it.latitude}\nlongitude: ${it.longitude}"
                emojiAndNameCountry.text = emojiAndName
                coordinatesCountry.text = coordinates
            }
            model.bank?.let {
                nameBank.text = it.name
                urlBank.text = it.url
                phoneBank.text = it.phone
            }
        }
    }
}