package com.sursulet.realestatemanager.domain.model

import java.text.NumberFormat
import java.time.LocalDate
import java.util.*

data class Estate(
    val photos: List<Photo>,
    val type: String,
    val price: Float,
    val surface: Float,
    val rooms: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val description: String,
    val address: Address,
    val nearby: String,
    val isAvailable: Boolean,
    val created: LocalDate,
    val saleTimestamp: LocalDate?,
    val agent: String
) {
    fun formattedPrice(): String = NumberFormat.getNumberInstance(Locale.US).format(price)
    fun formattedNearby(value: List<String>): String = value.joinToString(",")
}
