package com.example.app_proyecto_final.domain.usecase

import com.example.app_proyecto_final.data.ProductRepository
import com.example.app_proyecto_final.domain.model.ProductModel

class GetFavoriteListUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun invoke(): List<ProductModel> = productRepository.getFavoriteList()
}