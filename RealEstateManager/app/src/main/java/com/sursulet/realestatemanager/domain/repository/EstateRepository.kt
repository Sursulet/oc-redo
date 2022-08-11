package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.EstateDto
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.Estate
import com.sursulet.realestatemanager.domain.model.EstateItem
import kotlinx.coroutines.flow.Flow

interface EstateRepository {
    suspend fun insert(estate: EstateDto): Long
    suspend fun update(estate: EstateDto)
    suspend fun getEstateById(id: Long): EstateDto
    suspend fun getEstateWithPhotosById(id: Long): Estate
    fun getEstates(): Flow<List<EstateDto>>
    fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>>
    fun getEstateItems(): Flow<List<EstateItem>>
}