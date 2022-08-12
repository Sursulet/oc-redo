package com.sursulet.realestatemanager.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(address: AddressDto)

    @Query("SELECT * FROM address")
    fun getAddresses(): Flow<List<AddressDto>>
}