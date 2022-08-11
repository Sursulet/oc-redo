package com.sursulet.realestatemanager.domain.model

import android.graphics.Bitmap

data class EstateItem(
    val id: Long,
    val photo: Bitmap,
    val type: String,
    val price: Float,
    val city: String
)
