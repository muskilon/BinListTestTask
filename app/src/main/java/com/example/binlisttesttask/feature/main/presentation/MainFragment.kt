package com.example.binlisttesttask.feature.main.presentation

import android.os.Bundle
import android.view.View
import com.example.binlisttesttask.base.BaseFragment
import com.example.binlisttesttask.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val viewModel by viewModel<MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchButton.setOnClickListener {
            viewModel.search(binding.binInput.text.toString())
        }

    }
}