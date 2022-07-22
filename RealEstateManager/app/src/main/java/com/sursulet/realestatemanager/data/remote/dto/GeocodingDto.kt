package com.sursulet.realestatemanager.data.remote.dto

import com.squareup.moshi.Json

data class GeocodingDto(
    @field:Json(name = "address_components")
    val addressComponents: List<AddressComponentDto>,

    @field:Json(name = "formatted_address")
    val formattedAddress: String,

    val geometry: GeometryDto,

    @field:Json(name = "place_id")
    val placeID: String,

    @field:Json(name = "plus_code")
    val plusCode: PlusCodeDto,

    val types: List<String>
)
