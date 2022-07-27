package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.Photo

interface PhotoRepository {
    suspend fun insert(photos: List<Photo>)
}