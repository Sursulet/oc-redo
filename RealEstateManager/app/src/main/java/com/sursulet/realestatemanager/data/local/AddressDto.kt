package com.sursulet.realestatemanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address")
data class AddressDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val estateId: Long,
    val street: String,
    val extras: String? = null,
    val city: String,
    val state: String,
    val zip: String,
    val country: String
)
