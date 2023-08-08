package com.example.app_proyecto_final.domain.usecase

import com.example.app_proyecto_final.data.ProductRepository
import com.example.app_proyecto_final.domain.model.ProductModel

class GetProductByIdUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun invoke(id: String) : ProductModel = productRepository.getProductById(id)
}