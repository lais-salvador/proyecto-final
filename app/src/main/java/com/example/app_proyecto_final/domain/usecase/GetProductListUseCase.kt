package com.example.app_proyecto_final.domain.usecase

import com.example.app_proyecto_final.data.ProductRepository
import com.example.app_proyecto_final.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

class GetProductListUseCase(
    private val productRepository: ProductRepository
) {
    suspend fun invoke() : List<ProductModel> = productRepository.getProductList()
}