package com.example.app_proyecto_final.data.remote.dto

import com.squareup.moshi.Json

data class RatingDto(
    @Json(name = "rate") val rate: Double?,
    @Json(name = "count") val count: Int?
)