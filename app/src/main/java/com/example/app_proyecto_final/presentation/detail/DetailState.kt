package com.example.app_proyecto_final.presentation.detail

import com.example.app_proyecto_final.domain.model.ProductModel

sealed class DetailState {
    object Idle : DetailState()
    object Loading : DetailState()
    data class Product(val product: ProductModel) : DetailState()
}