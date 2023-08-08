package com.example.app_proyecto_final.data.remote.dto
import android.icu.text.CaseMap.Title
import com.squareup.moshi.Json

data class ProductDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "image") val image: String?,
    @Json(name = "price") val price: Double?,
    @Json(name = "category") val category: String?,
    @Json(name = "rating") val rating: RatingDto?
)