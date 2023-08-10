package com.example.app_proyecto_final.domain.usecase

import com.example.app_proyecto_final.data.ProductRepository

class UpdateFavoriteStateOfProductUseCase(
    private var productRepository: ProductRepository
    ) {
    suspend fun invoke(isFavorite: Boolean, productId: String) : Boolean = productRepository.updateFavoriteStateOfProduct(isFavorite, productId)
}