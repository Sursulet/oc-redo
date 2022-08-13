package com.sursulet.realestatemanager.data.remote.dto

data class GeocodingDto(
    val results: List<GeocodingItemDto>,
    val status: String
)
