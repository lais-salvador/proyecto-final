package com.example.app_proyecto_final.data.remote

import com.example.app_proyecto_final.data.ProductApi
import com.example.app_proyecto_final.data.remote.dto.ProductDto

class RemoteDataSourceImpl(
    private val productApi: ProductApi
): RemoteDataSource {
    override suspend fun getProductList(): List<ProductDto> = productApi.getProductList()
    override suspend fun getProductById(id: String): ProductDto = productApi.getProductById(id)
}