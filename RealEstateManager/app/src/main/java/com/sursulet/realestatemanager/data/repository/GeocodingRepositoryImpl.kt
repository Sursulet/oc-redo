package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.remote.GeocodingApi
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import com.sursulet.realestatemanager.domain.utils.Resource
import javax.inject.Inject

class GeocodingRepositoryImpl @Inject constructor(
    private val api: GeocodingApi
) : GeocodingRepository {

    override suspend fun getCoordinates(address: String): Resource<String> {
        return try {
            Resource.Success(
                data = api.getCoordinates(address = address).toString()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}