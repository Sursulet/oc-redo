package com.sursulet.realestatemanager.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class EstateWithPhotos(
    @Embedded val estate: EstateWithAddress,
    @Relation(
        parentColumn = "id",
        entityColumn = "estateId"
    )
    val photos: List<PhotoDto>
)
