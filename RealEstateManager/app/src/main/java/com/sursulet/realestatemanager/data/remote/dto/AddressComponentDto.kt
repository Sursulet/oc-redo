package com.sursulet.realestatemanager.data.remote.dto

import com.squareup.moshi.Json

data class AddressComponentDto(
    @field:Json(name = "long_name")
    val longName: String,

    @field:Json(name = "short_name")
    val shortName: String,

    val types: List<String>
)
