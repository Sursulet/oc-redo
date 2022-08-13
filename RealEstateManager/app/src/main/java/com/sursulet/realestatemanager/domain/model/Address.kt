package com.sursulet.realestatemanager.domain.model

data class Address(
    val estateId: Long,
    val street: String,
    val extras: String? = null,
    val city: String,
    val state: String,
    val zip: String,
    val country: String
) {
    //private val stateCode: String = "$state $postCode"

    fun toString(separator: String): String = listOfNotNull(
        street, extras.takeUnless { it.isNullOrEmpty() }, city,
        "$state $zip",
        country
    ).joinToString(separator)
}
