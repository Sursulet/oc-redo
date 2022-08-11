package com.sursulet.realestatemanager.data.local

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Query("SELECT * FROM address")
    fun getAddresses(): Flow<List<AddressDto>>
}