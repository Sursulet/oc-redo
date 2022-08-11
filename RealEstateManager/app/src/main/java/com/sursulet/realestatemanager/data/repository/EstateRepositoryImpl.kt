package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.EstateDao
import com.sursulet.realestatemanager.data.local.EstateDto
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.data.local.RealEstateManagerDatabase
import com.sursulet.realestatemanager.data.mappers.toEstate
import com.sursulet.realestatemanager.data.mappers.toEstateItem
import com.sursulet.realestatemanager.di.IoDispatcher
import com.sursulet.realestatemanager.domain.model.Estate
import com.sursulet.realestatemanager.domain.model.EstateItem
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EstateRepositoryImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    database: RealEstateManagerDatabase
) : EstateRepository {

    private val dao: EstateDao = database.estateDao()

    override suspend fun insert(estate: EstateDto
    ): Long {
        return dao.insert(estate)
    }

    override suspend fun update(estate: EstateDto) {
        return dao.update(estate)
    }

    override suspend fun getEstateById(id: Long): EstateDto {
        return dao.getEstateById(id)
    }

    override suspend fun getEstateWithPhotosById(id: Long): Estate {
        return withContext(dispatcher) {
            dao.getEstateWithPhotosById(id)
                .toEstate()
        }
    }

    override fun getEstates(): Flow<List<EstateDto>> {
        return dao.getEstates()
    }

    override fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>> {
        return dao.getEstatesWithPhotos()
    }

    override fun getEstateItems(): Flow<List<EstateItem>> {
        return dao.getEstateItems().map { list ->
            list.map { it.toEstateItem() }
        }
    }
}