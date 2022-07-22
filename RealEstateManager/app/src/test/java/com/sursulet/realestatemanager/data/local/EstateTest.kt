package com.sursulet.realestatemanager.data.local

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class EstateTest {

    private lateinit var estate: Estate

    @Before
    fun setUp() {
        estate = Estate(
            id = 1,
            type = "Castle", price = 1000500f, surface = 27f,
            rooms = 1, description = "description", photos = "",
            address = Address(street = "16 rue ", null, null, null, postCode = "23", ""),
            nearby = "school, market",
            agent = ""
        )
    }

    @Test
    fun test_shouldBeFormatted() {
        val result = estate.formattedPrice()
        Truth.assertThat(result).isEqualTo("1,000,500")
    }

    @Test
    fun test_shouldBeFormattedNearby() {
        Truth.assertThat(estate.formattedNearby(listOf("school", "market")))
            .isEqualTo("school,market")
    }
}