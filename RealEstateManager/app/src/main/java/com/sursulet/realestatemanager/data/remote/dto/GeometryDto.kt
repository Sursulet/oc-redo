package com.sursulet.realestatemanager.data.remote.dto

import com.squareup.moshi.Json

data class GeometryDto(
    val location: LocationDto,

    @field:Json(name = "location_type")
    val locationType: String,

    val viewport: ViewportDto
)
