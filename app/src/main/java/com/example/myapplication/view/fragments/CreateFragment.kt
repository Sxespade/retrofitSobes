package com.example.myapplication.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.data.state.AppState
import com.example.myapplication.databinding.FragmentCreateBinding
import com.example.myapplication.viewmodel.CreateViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateFragment: Fragment(R.layout.fragment_create) {

    private val viewModel: CreateViewModel by viewModel()
    lateinit var binding: FragmentCreateBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateBinding.bind(view)

        viewModel.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })


        binding.button.setOnClickListener {
            viewModel.initRetrofit(binding.dataQuestionsInput.text.toString())
        }

    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success<*> -> {
                when (appState.data) {
                    is List<*> -> {
                    }
                    else -> {
                    }
                }
            }
        }
    }


}