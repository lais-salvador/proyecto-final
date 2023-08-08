package com.example.app_proyecto_final.data

import com.example.app_proyecto_final.domain.model.ProductModel

interface ProductRepository {
    suspend fun getProductList(): List<ProductModel>

    suspend fun getProductById(id: String): ProductModel
}