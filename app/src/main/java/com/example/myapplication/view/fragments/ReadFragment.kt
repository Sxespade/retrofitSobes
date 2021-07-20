package com.example.myapplication.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.data.state.AppState
import com.example.myapplication.databinding.FragmentConclusionBinding
import com.example.myapplication.databinding.FragmentCreateBinding
import com.example.myapplication.databinding.FragmentReadBinding
import com.example.myapplication.viewmodel.ConclusionViewModel
import com.example.myapplication.viewmodel.CreateViewModel
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel

class ReadFragment: Fragment(R.layout.fragment_read) {

//    private val viewModel: ConclusionViewModel by viewModel()
    lateinit var binding: FragmentReadBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentReadBinding.bind(view)

        binding.textView6.text = arguments?.getString("1")

    }
}