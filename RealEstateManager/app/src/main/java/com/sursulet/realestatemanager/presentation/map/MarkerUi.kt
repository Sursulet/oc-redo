package com.sursulet.realestatemanager.presentation.map

import android.location.Location
import android.location.LocationManager
import com.google.android.gms.maps.model.LatLng

data class MarkerUi(
    val id: Long,
    val coordinates: LatLng,
    val distance: Float
) {
    fun shouldBeZone(radius: Float, location: Location) =
        radius > location.distanceTo(Location(LocationManager.GPS_PROVIDER)
            .apply {
                latitude = location.latitude
                longitude = location.longitude
            })
}
