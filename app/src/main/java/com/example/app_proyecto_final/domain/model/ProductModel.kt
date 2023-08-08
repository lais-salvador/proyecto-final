package com.example.app_proyecto_final.domain.model

data class ProductModel(
        val id: Int,
        val title: String,
        val description: String,
        val price: Double,
        val category: String,
        val image: String,
        val rating: RatingModel
        )