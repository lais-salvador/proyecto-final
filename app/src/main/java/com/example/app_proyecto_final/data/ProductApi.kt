package com.example.app_proyecto_final.data

import com.example.app_proyecto_final.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductApi {
    @GET("/products")
    suspend fun getProductList(): List<ProductDto>

    @GET("/products/{id}")
    suspend fun getProductById(@Path("id") id: String): ProductDto
}
