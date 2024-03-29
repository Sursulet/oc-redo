package com.sursulet.realestatemanager.data.local

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class PhotoDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val estateId: Long,
    var title: String,
    var image: Bitmap
)
