package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.EstateDto
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.Estate
import com.sursulet.realestatemanager.domain.model.EstateItem
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeEstateRepository : EstateRepository {

    private val estates = mutableListOf<EstateDto>()

    private val getEstates = flow<List<EstateDto>> { emit(estates) }

    override suspend fun insert(estate: EstateDto): Long {
        estates.add(estate)
        return estate.id
    }

    override suspend fun update(estate: EstateDto) {
        TODO("Not yet implemented")
    }

    override suspend fun getEstateById(id: Long): EstateDto {
        TODO("Not yet implemented")
    }

    override suspend fun getEstateWithPhotosById(id: Long): Estate {
        TODO("Not yet implemented")
    }

    override fun getEstates(): Flow<List<EstateDto>> {
        return getEstates
    }

    override fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>> {
        TODO("Not yet implemented")
    }

    override fun getEstateItems(): Flow<List<EstateItem>> {
        TODO("Not yet implemented")
    }
}