package com.sursulet.realestatemanager.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EstateDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estate: EstateDto): Long

    @Update
    suspend fun update(estate: EstateDto)

    @Delete
    suspend fun delete(estate: EstateDto)

    @Query("SELECT * FROM estate")
    fun getEstates(): Flow<List<EstateDto>>

    @Query("SELECT * FROM estate WHERE id = :id")
    fun getEstateById(id: Long): EstateDto

    @Transaction
    @Query("SELECT * FROM estate")
    fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>>

    @Transaction
    @Query("SELECT * FROM estate WHERE id = :id")
    fun getEstateWithPhotosById(id: Long): EstateWithPhotos

    @Query("SELECT * FROM estateitemdto")
    fun getEstateItems(): Flow<List<EstateItemDto>>
}