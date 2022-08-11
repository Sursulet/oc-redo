package com.sursulet.realestatemanager.data.local

import android.graphics.Bitmap
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class ConvertersTest {

    @SpyK
    lateinit var converters: Converters// = spyk<Converters>()

    @Before
    fun setUp() {
        converters = Converters()
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun `with Null String should returns Null`() {
        assertThat(converters.fromTimestamp(null))
            .isEqualTo(null)
    }

    @Test
    fun shouldBeDate() {
        assertThat(converters.fromTimestamp(0L))
            .isEqualTo(LocalDate.parse("1970-01-01"))
    }

    @Test
    fun shouldBeString() {
        assertThat(converters.dateToTimestamp(LocalDate.parse("1970-01-01")))
            .isEqualTo(0L)
    }

    @Test
    fun shouldToByteArray() {
        val bitmap = mockk<Bitmap>()
        val byteArray = "Bitmap".toByteArray(Charsets.UTF_8)

        every { converters.bitmapToByteArray(bitmap) } returns byteArray

        assertThat(converters.bitmapToByteArray(bitmap))
            .isEqualTo("Bitmap".toByteArray(Charsets.UTF_8))
    }
}