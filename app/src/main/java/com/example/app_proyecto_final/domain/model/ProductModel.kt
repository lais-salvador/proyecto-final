package com.example.app_proyecto_final.domain.model

data class ProductModel(
        val id: String,
        val title: String,
        val description: String,
        val price: String,
        val category: String,
        val image: String,
        val rating: RatingModel
        )