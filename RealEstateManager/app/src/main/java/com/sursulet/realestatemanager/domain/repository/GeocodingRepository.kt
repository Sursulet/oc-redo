package com.sursulet.realestatemanager.domain.repository

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.domain.utils.Resource

interface GeocodingRepository {
    suspend fun getCoordinates(address: String): Resource<Location>
}