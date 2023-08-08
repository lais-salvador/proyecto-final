package com.example.app_proyecto_final.presentation.list

import com.example.app_proyecto_final.domain.model.ProductModel

sealed class ListState {
    object Idle : ListState()
    object Loading : ListState()
    data class ProductList(val productList: List<ProductModel>) : ListState()
}