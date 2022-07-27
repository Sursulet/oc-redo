package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeEstateRepository : EstateRepository {

    private val estates = mutableListOf<Estate>()

    private val getEstates = flow<List<Estate>> { emit(estates) }

    override suspend fun insert(estate: Estate) {
        estates.add(estate)
    }

    override suspend fun update(estate: Estate) {
        TODO("Not yet implemented")
    }

    override suspend fun getEstateById(id: Long): Estate {
        TODO("Not yet implemented")
    }

    override suspend fun getEstateWithPhotosById(id: Long): EstateWithPhotos {
        TODO("Not yet implemented")
    }

    override fun getEstates(): Flow<List<Estate>> {
        return getEstates
    }

    override fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>> {
        TODO("Not yet implemented")
    }
}