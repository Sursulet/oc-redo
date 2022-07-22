package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.EstateDao
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EstateRepositoryImpl @Inject constructor(
    private val dao: EstateDao
): EstateRepository {
    override suspend fun insert(estate: Estate) {
        return dao.insert(estate)
    }

    override suspend fun update(estate: Estate) {
        return dao.update(estate)
    }

    override suspend fun getEstateById(id: Long): Estate {
        return dao.getEstateById(id)
    }

    override suspend fun getEstateWithPhotosById(id: Long): EstateWithPhotos {
        return dao.getEstateWithPhotosById(id)
    }

    override fun getEstates(): Flow<List<Estate>> {
        return dao.getEstates()
    }

    override fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>> {
        return dao.getEstatesWithPhotos()
    }
}