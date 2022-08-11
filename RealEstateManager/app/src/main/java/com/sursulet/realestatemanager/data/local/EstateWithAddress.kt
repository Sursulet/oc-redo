package com.sursulet.realestatemanager.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class EstateWithAddress(
    @Embedded val estate: EstateDto,
    @Relation(
        parentColumn = "id",
        entityColumn = "estateId"
    )
    val address: AddressDto
)
