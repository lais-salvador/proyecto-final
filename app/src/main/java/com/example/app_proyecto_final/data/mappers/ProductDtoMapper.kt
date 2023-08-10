package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.data.local.model.ProductLocal
import com.example.app_proyecto_final.data.remote.dto.ProductDto
import com.example.app_proyecto_final.domain.model.ProductModel
import java.text.DecimalFormat

fun ProductDto.toProductModel() = ProductModel(
    id = id?.toString() ?: "",
    title = title ?: "",
    description = description ?: "",
    image = image ?: "",
    price = price?.let {
        formatPrice(it)
    } ?: "",
    category = category ?: "",
    favorite = false
)

fun ProductDto.toProductLocal() = ProductLocal(
    id = id?.toString() ?: "",
    title = title ?: "",
    description = description ?: "",
    image = image ?: "",
    price = price?.let {
        formatPrice(it)
    } ?: "",
    category = category ?: "",
    favorite = false
)

private fun formatPrice(number: Double): String {
    val  df = DecimalFormat("#.00")
    return df.format(number).toString() + "€"
}

