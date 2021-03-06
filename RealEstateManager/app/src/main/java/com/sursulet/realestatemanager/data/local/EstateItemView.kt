package com.sursulet.realestatemanager.data.local

import android.graphics.Bitmap
import androidx.room.DatabaseView

@DatabaseView(
    """
    SELECT estate.id, estate.type, estate.city, estate.price, photo.image AS photo FROM estate
    INNER JOIN photo
    ON estate.id = photo.estateId
    LIMIT 1
    """
)
data class EstateItemView(
    val id: Long,
    val type: String,
    val city: String,
    val price: Float,
    val photo: Bitmap
)
