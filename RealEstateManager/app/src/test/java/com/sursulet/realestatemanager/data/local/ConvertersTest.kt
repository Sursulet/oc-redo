package com.sursulet.realestatemanager.data.local

import android.graphics.Bitmap
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test
import java.time.LocalDate

class ConvertersTest {

    private lateinit var converters: Converters
    //@MockK private lateinit var bitmap: Bitmap
    //private val bitmap: Bitmap = Bitmap.createBitmap(16,16,Bitmap.Config.ARGB_8888)

    @Before
    fun setUp() {
        converters = Converters()
        //bitmap = mockk()//Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
        MockKAnnotations.init(this, relaxUnitFun = true)
    }

    @Test
    fun shouldBeDate() {
        val value = LocalDate.parse("2022-07-12")
        Truth.assertThat(converters.fromString("2022-07-12")).isEqualTo(value)
    }

    @Test
    fun shouldBeString() {
        Truth.assertThat(converters.dateToString(LocalDate.parse("2022-07-21")))
            .isEqualTo("2022-07-21")
    }

    @Test
    fun shouldToByteArray() {
        val bitmap: Bitmap = Bitmap.createBitmap(16,16,Bitmap.Config.ARGB_8888)
        Truth.assertThat(converters.bitmapToByteArray(bitmap))
            .isEqualTo("Hello".toByteArray(Charsets.UTF_8))
    }
}