package com.sursulet.realestatemanager.data.local

data class Address(
    val street: String,
    val extras: String? = null,
    val state: String,
    val city: String,
    val zip: String,
    val country: String
) {
    //private val stateCode: String = "$state $postCode"

    override fun toString(): String = listOfNotNull(
        street, extras.takeUnless { it.isNullOrEmpty() }, city,
        "$state $zip",
        country
    ).joinToString("\n")
}
