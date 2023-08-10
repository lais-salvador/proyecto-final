package com.example.app_proyecto_final.presentation.favorite

import com.example.app_proyecto_final.domain.model.ProductModel

sealed class FavoriteState {
    object Idle : FavoriteState()
    object Loading : FavoriteState()
    object Error: FavoriteState()
    data class ProductList(val productList: List<ProductModel>) : FavoriteState()
}