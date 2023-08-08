package com.example.app_proyecto_final.di

import com.example.app_proyecto_final.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val PresentationModule = module {
    viewModel { ListViewModel(get()) }
}