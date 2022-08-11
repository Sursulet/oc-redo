package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.PhotoDto

interface PhotoRepository {
    suspend fun insert(photos: List<PhotoDto>)
    suspend fun delete(photo: PhotoDto)
}