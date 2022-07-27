package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.EstateDao
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.data.mappers.toEstateData
import com.sursulet.realestatemanager.data.mappers.toEstateDetailData
import com.sursulet.realestatemanager.domain.model.DetailData
import com.sursulet.realestatemanager.domain.model.EstateData
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EstateRepositoryImpl @Inject constructor(
    private val dao: EstateDao
) : EstateRepository {

    override suspend fun insert(estate: Estate): Long {
        return dao.insert(estate)
    }

    override suspend fun update(estate: Estate) {
        return dao.update(estate)
    }

    override suspend fun getEstateById(id: Long): Estate {
        return dao.getEstateById(id)
    }

    override suspend fun getEstateWithPhotosById(id: Long): DetailData {
        return dao.getEstateWithPhotosById(id).toEstateDetailData()
    }

    override fun getEstates(): Flow<List<Estate>> {
        return dao.getEstates()
    }

    override fun getEstatesWithPhotos(): Flow<List<EstateWithPhotos>> {
        return dao.getEstatesWithPhotos()
    }

    override fun getEstateItems(): Flow<List<EstateData>> {
        return dao.getEstateItems().map { list ->
            list.map { it.toEstateData() }
        }
        /*
            flow {
                val itemList = dao.getEstateItems().first()
                emit(Resource.Success(data = itemList.map { it.toEstateData() }))
            }*/
    }
}