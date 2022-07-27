package com.sursulet.realestatemanager.data.local

import android.graphics.Bitmap
import com.google.common.truth.Truth
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
    fun shouldBeDate() {
        Truth.assertThat(converters.fromString("2022-07-12"))
            .isEqualTo(LocalDate.parse("2022-07-12"))
    }

    @Test
    fun shouldBeString() {
        Truth.assertThat(converters.dateToString(LocalDate.parse("2022-07-21")))
            .isEqualTo("2022-07-21")
    }

    @Test
    fun shouldToByteArray() {
        val bitmap = mockk<Bitmap>()
        val byteArray = "Bitmap".toByteArray(Charsets.UTF_8)

        every { converters.bitmapToByteArray(bitmap) } returns byteArray

        Truth.assertThat(converters.bitmapToByteArray(bitmap))
            .isEqualTo("Bitmap".toByteArray(Charsets.UTF_8))
    }
}