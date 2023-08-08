package com.example.app_proyecto_final.data.remote

import com.example.app_proyecto_final.data.remote.dto.ProductDto

interface RemoteDataSource {
    suspend fun getProductList(): List<ProductDto>

    suspend fun getProductById(id: String): ProductDto
}