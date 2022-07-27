package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.DetailData
import com.sursulet.realestatemanager.domain.model.EstateData
import kotlinx.coroutines.flow.Flow

interface EstateRepository {
    suspend fun insert(estate: Estate): Long
    suspend fun update(estate: Estate)
    suspend fun getEstateById(id: Long): Estate
    suspend fun getEstateWithPhotosById(id: Long): DetailData
    fun getEstates(): Flow<List<Estate>>
    fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>>
    fun getEstateItems(): Flow<List<EstateData>>
}