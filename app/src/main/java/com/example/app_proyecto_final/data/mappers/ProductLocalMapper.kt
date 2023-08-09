package com.example.app_proyecto_final.data.mappers

import com.example.app_proyecto_final.data.local.model.ProductLocal
import com.example.app_proyecto_final.domain.model.ProductModel

fun ProductLocal.toProductModel(): ProductModel = ProductModel(
    id = id,
    title = title,
    description = description,
    image = image,
    price = price,
    category = category,
)