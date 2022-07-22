package com.sursulet.realestatemanager.data.remote.dto

import com.squareup.moshi.Json

data class PlusCodeDto(
    @field:Json(name = "compound_code")
    val compoundCode: String,

    @field:Json(name = "global_code")
    val globalCode: String
)
