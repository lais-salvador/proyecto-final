package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.domain.model.RatingModel

fun ProductDto.toProductModel() = ProductModel(
    id = id ?: 0,
    title = title ?: "",
    description = description ?: "",
    image = image ?: "",
    price = price ?: 0.0,
    category = category ?: "",
    rating = rating?.toRatingModel() ?: RatingModel(0.0,0)
)
