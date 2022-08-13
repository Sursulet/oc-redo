package com.sursulet.realestatemanager.domain.repository

import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.domain.utils.Resource

interface GeocodingRepository {
    suspend fun getCoordinates(address: String): Resource<LatLng>
}