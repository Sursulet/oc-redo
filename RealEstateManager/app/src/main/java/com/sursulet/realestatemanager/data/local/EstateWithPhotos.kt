package com.sursulet.realestatemanager.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class EstateWithPhotos(
    @Embedded val estate: Estate,
    @Relation(
        parentColumn = "id",
        entityColumn = "estateId"
    )
    val photos: List<Photo>
)
