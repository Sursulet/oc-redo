package com.sursulet.realestatemanager.domain.model

import android.graphics.Bitmap

data class EstateData(
    val id: Long,
    val photo: Bitmap,
    val type: String,
    val city: String,
    val price: String
)
