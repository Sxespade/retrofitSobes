package com.example.myapplication.di

import com.example.myapplication.retrofit.RetrofitImplementation
import com.example.myapplication.viewmodel.ConclusionViewModel
import com.example.myapplication.viewmodel.CreateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Alex Volkov(Volkoks)
 *
 * Created 08.04.2021
 */
val appModule = module {
    single { RetrofitImplementation().initRetorfit() }
}

val conclusionFragmentModuule = module {
    single { RetrofitImplementation()}
    viewModel { ConclusionViewModel(get()) }
}

val createFragmentModuule = module {
    viewModel { CreateViewModel(get()) }
}


