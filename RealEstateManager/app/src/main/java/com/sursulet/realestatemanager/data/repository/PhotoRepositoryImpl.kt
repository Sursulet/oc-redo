package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.Photo
import com.sursulet.realestatemanager.data.local.RealEstateManagerDatabase
import com.sursulet.realestatemanager.domain.repository.PhotoRepository
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    database: RealEstateManagerDatabase
): PhotoRepository {

    val dao = database.photoDao()

    override suspend fun insert(photos: List<Photo>) {
        dao.insert(photos)
    }
}