package com.sursulet.realestatemanager.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EstateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estate: Estate)

    @Update
    suspend fun update(estate: Estate)

    @Delete
    suspend fun delete(estate: Estate)

    @Query("SELECT * FROM estate")
    fun getEstates(): Flow<List<Estate>>

    @Query("SELECT * FROM estate WHERE id = :id")
    fun getEstateById(id: Long): Estate

    @Transaction
    @Query("SELECT * FROM estate")
    fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>>

    @Transaction
    @Query("SELECT * FROM estate WHERE id = :id")
    fun getEstateWithPhotosById(id: Long): EstateWithPhotos
}