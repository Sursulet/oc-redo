package com.sursulet.realestatemanager.data.remote.dto

import android.location.Location
import com.squareup.moshi.Json

data class GeometryDto(
    val location: Location,

    @field:Json(name = "location_type")
    val locationType: String,

    val viewport: ViewportDto
)
