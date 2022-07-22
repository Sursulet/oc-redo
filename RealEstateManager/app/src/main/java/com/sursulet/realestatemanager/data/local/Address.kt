package com.sursulet.realestatemanager.data.local

import androidx.room.ColumnInfo

data class Address(
    val street: String?,
    val extras: String?,
    val state: String?,
    val city: String?,
    @ColumnInfo(name = "post_code") val postCode: String?,
    val country: String?
) {
    //private val stateCode: String = "$state $postCode"

    override fun toString(): String = listOfNotNull(
        street, extras.takeUnless { it.isNullOrEmpty() }, city,
        "$state $postCode",
        country
    ).joinToString("\n")
}
