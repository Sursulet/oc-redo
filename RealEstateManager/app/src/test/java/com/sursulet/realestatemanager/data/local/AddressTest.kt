package com.sursulet.realestatemanager.data.local

import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class AddressTest {

    private lateinit var address: Address

    @Before
    fun setUp() {
        address = Address(
            street = "760 Park Avenue",
            extras = "Apt 6/7",
            state = "NY",
            city = "New York",
            zip = "10021",
            country = "UNITED STATES"
        )
    }

    @Test
    fun shouldBeString() {
        Truth.assertThat(address.toString())
            .isEqualTo("760 Park Avenue\nApt 6/7\nNew York\nNY 10021\nUNITED STATES")
    }

    @Test
    fun shouldBeNotExtras() {
        val value = address.copy(extras = "")
        Truth.assertThat(value.toString())
            .isEqualTo("760 Park Avenue\nNew York\nNY 10021\nUNITED STATES")
    }

    @Test
    fun whenExtrasIsNull() {
        Truth.assertThat(address.copy(extras = null).toString())
            .isEqualTo("760 Park Avenue\nNew York\nNY 10021\nUNITED STATES")
    }
}