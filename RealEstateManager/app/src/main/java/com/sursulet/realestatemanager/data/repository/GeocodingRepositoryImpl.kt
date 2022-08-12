package com.sursulet.realestatemanager.data.repository

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.data.mappers.toLatLng
import com.sursulet.realestatemanager.data.remote.GeocodingApi
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import com.sursulet.realestatemanager.domain.utils.Resource
import javax.inject.Inject

class GeocodingRepositoryImpl @Inject constructor(
    private val api: GeocodingApi
) : GeocodingRepository {

    override suspend fun getCoordinates(address: String): Resource<Location> {
        return try {
            Resource.Success(
                data = api.getCoordinates(address = address).toLatLng()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}