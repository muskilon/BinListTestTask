package com.example.binlisttesttask.feature.history.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.databinding.CardInfoSnippetBinding
import com.example.binlisttesttask.core.domain.models.CardInfo

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {
    private val items = ArrayList<CardInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            CardInfoSnippetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setData(newItems: List<CardInfo>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}