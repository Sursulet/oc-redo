package com.sursulet.realestatemanager.domain.model

import com.sursulet.realestatemanager.data.local.Photo

data class DetailData(
    val gallery: List<Photo>,
    val description: String,
    val surface: String,
    val rooms: String,
    val bathrooms: String,
    val bedrooms: String,
    val address: String
)
