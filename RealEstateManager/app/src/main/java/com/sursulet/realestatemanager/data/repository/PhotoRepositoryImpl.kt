package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.PhotoDto
import com.sursulet.realestatemanager.data.local.RealEstateManagerDatabase
import com.sursulet.realestatemanager.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    database: RealEstateManagerDatabase
): PhotoRepository {

    val dao = database.photoDao()

    override suspend fun insert(photos: List<PhotoDto>) {
        dao.insert(photos)
    }

    override suspend fun delete(photo: PhotoDto) {
        dao.delete(photo)
    }
}