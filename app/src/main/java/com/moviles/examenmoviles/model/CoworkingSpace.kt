package com.moviles.examenmoviles.model

import androidx.annotation.DrawableRes

data class CoworkingSpace(
    val id: String,
    val name: String,
    val shortDescription: String,
    val fullDescription: String,
    val location: String,
    val capacity: Int,
    val pricePerHour: Double,
    val isAvailable: Boolean,
    @DrawableRes val imageRes: Int,
    val amenities: List<String>
)

