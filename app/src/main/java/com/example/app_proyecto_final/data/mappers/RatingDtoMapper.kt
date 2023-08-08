package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.data.remote.dto.RatingDto
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.domain.model.RatingModel

fun RatingDto.toRatingModel() = RatingModel(
        rate = rate ?: 0.0,
        count = count ?: 0
    )

