package com.example.binlisttesttask.feature.history.presentation

import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.R
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.databinding.CardInfoSnippetBinding

class HistoryViewHolder(
    private val binding: CardInfoSnippetBinding
) : RecyclerView.ViewHolder(binding.root) {
    private var uri: Uri? = null
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
                uri = Uri.parse(
                    this.root.context.getString(
                        R.string.geo_url,
                        it.latitude,
                        it.longitude,
                        it.name
                    )
                )
                val emojiAndName = "${it.emoji}  ${it.name}"
                emojiAndNameCountry.text = emojiAndName
                coordinatesCountry.text = this.root.context.getString(
                    R.string.country_coordinates,
                    it.latitude,
                    it.longitude
                )
            }
            model.bank?.let {
                nameBank.text = it.name
                urlBank.text = it.url
                phoneBank.text = it.phone
            }
        }
    }

    fun setClickListener() {
        binding.coordinatesCountry.setOnClickListener {
            uri?.let {
                startActivity(this.binding.root.context, Intent(Intent.ACTION_VIEW, uri), null)
            }
        }
    }
}