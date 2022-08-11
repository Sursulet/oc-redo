package com.sursulet.realestatemanager.domain.model

import android.graphics.Bitmap

data class Photo(
    val id: Long,
    val title: String,
    val image: Bitmap,
    val delete: Boolean = false
)
