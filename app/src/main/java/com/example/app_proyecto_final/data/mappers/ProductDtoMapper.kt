package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.domain.model.ProductModel
import com.example.app_proyecto_final.domain.model.RatingModel
import okhttp3.internal.format
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToLong

fun ProductDto.toProductModel() = ProductModel(
    id = id ?: 0,
    title = title ?: "",
    description = description ?: "",
    image = image ?: "",
    price = price?.let {
        formatPrice(it)
    } ?: "",
    category = category ?: "",
    rating = rating?.toRatingModel() ?: RatingModel(0.0,0)
)

private fun formatPrice(number: Double): String {
    val  df = DecimalFormat("#.00")
    return df.format(number).toString() + "€"
}

