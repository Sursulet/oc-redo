package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import kotlinx.coroutines.flow.Flow

interface EstateRepository {
    suspend fun insert(estate: Estate)
    suspend fun update(estate: Estate)
    suspend fun getEstateById(id: Long): Estate
    suspend fun getEstateWithPhotosById(id: Long): EstateWithPhotos
    fun getEstates(): Flow<List<Estate>>
    fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>>
}