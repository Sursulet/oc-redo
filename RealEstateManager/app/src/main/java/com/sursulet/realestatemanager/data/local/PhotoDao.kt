package com.sursulet.realestatemanager.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface PhotoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photos: List<PhotoDto>)

    @Delete
    suspend fun delete(photo: PhotoDto)
}