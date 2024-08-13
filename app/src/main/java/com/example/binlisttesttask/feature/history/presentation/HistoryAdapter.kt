package com.example.binlisttesttask.feature.history.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.binlisttesttask.core.domain.models.CardInfo
import com.example.binlisttesttask.databinding.CardInfoSnippetBinding

class HistoryAdapter : RecyclerView.Adapter<HistoryViewHolder>() {
    private val items = ArrayList<CardInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val viewHolder = HistoryViewHolder(
            CardInfoSnippetBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
        viewHolder.setClickListener()
        return viewHolder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newItems: List<CardInfo>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}