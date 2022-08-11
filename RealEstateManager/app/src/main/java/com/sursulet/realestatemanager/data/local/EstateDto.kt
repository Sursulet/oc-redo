package com.sursulet.realestatemanager.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "estate")
data class EstateDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val type: String,
    val price: Float,
    val surface: Float,
    val rooms: Int,
    val description: String,
    @Embedded val address: Address,
    val nearby: String,
    val isAvailable: Boolean = true,
    val created: LocalDate = LocalDate.now(),
    val saleTimestamp: LocalDate? = null,
    val agent: String
)
