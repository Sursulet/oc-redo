package com.sursulet.realestatemanager.data.local

import androidx.room.ColumnInfo

data class Address(
    val street: String? = null,
    val extras: String? = null,
    val state: String? = null,
    val city: String? = null,
    @ColumnInfo(name = "post_code") val postCode: String? = null,
    val country: String? = null
) {
    //private val stateCode: String = "$state $postCode"

    override fun toString(): String = listOfNotNull(
        street, extras.takeUnless { it.isNullOrEmpty() }, city,
        "$state $postCode",
        country
    ).joinToString("\n")
}
