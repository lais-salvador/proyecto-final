package com.example.app_proyecto_final.data.local

import com.example.app_proyecto_final.data.local.model.ProductLocal

interface LocalDataSource {
    suspend fun insertProductList(heroList: List<ProductLocal>)

    suspend fun getProductList() : List<ProductLocal>

    suspend fun getProductById(id: String) : ProductLocal

    suspend fun updateFavoriteStateOfProduct(isFavorite: Boolean, productId: String): Boolean

    suspend fun getFavoriteList(): List<ProductLocal>
}