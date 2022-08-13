package com.sursulet.realestatemanager.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class EstateDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: RealEstateManagerDatabase
    private lateinit var dao: EstateDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RealEstateManagerDatabase::class.java
        ).allowMainThreadQueries().build()

        dao = database.estateDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertEstate() = runTest {
        val item = EstateDto(
            id = 1,
            type = "",
            price = 1f,
            surface = 27f,
            rooms = 1,
            description = "",
            //address = Address("","","","","",""),
            nearby = "",
            isAvailable = true,
            //created = LocalDate.now(),
            //saleTimestamp = null,
            agent = ""
        )
        dao.insert(item)

        val list = dao.getEstates().first()

        assertThat(list.size).isEqualTo(1)
        assertThat(list).contains(item)
    }

    @Test
    fun getEstates() = runTest {
        val item = EstateDto(
            type = "",
            price = 1f,
            surface = 27f,
            rooms = 1,
            description = "",
            //address = Address("","","","","",""),
            nearby = "",
            isAvailable = true,
            //created = LocalDate.now(),
            //saleTimestamp = null,
            agent = ""
        )
        val item1 = EstateDto(
            type = "",
            price = 1f,
            surface = 27f,
            rooms = 1,
            description = "",
            //address = Address("","","","","",""),
            nearby = "",
            isAvailable = true,
            //created = LocalDate.now(),
            //saleTimestamp = null,
            agent = ""
        )

        dao.insert(item)
        dao.insert(item1)

        val list = dao.getEstates().first()
        assertThat(list.size).isEqualTo(2)
    }

    @Test
    fun getEstate() = runTest {  }

    @Test
    fun update() = runTest {
        val item = EstateDto(
            id = 1,
            type = "",
            price = 1f,
            surface = 27f,
            rooms = 1,
            description = "",
            //address = Address("","","","","",""),
            nearby = "",
            isAvailable = true,
            //created = LocalDate.now(),
            //saleTimestamp = null,
            agent = ""
        )
        dao.update(item)

        val copy = item.copy(price = 2f)
        dao.update(item)

        val list = dao.getEstates().first()

        assertThat(list.size).isEqualTo(1)
        assertThat(list).contains(copy)
        assertThat(list).doesNotContain(item)
    }
}