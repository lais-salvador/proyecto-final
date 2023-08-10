package com.example.app_proyecto_final.di

import com.example.app_proyecto_final.domain.usecase.GetFavoriteListUseCase
import com.example.app_proyecto_final.domain.usecase.GetProductByIdUseCase
import com.example.app_proyecto_final.domain.usecase.GetProductListUseCase
import com.example.app_proyecto_final.domain.usecase.UpdateFavoriteStateOfProductUseCase
import org.koin.dsl.module

val DomainModule = module {
    single { GetProductListUseCase(get()) }

    single { GetProductByIdUseCase(get()) }

    single { UpdateFavoriteStateOfProductUseCase(get()) }

    single { GetFavoriteListUseCase(get()) }
}