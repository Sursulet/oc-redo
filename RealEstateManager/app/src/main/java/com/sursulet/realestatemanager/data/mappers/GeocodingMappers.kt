package com.sursulet.realestatemanager.data.mappers

import android.location.Location
import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.data.remote.dto.GeocodingDto
import com.sursulet.realestatemanager.data.remote.dto.GeometryDto
import com.sursulet.realestatemanager.data.remote.dto.LocationDto
import com.sursulet.realestatemanager.domain.model.Geocoding
import com.sursulet.realestatemanager.domain.model.Geometry


fun GeocodingDto.toLatLng(): LatLng {
    return LatLng(
        results[0].geometry.location.lat,
        results[0].geometry.location.lng
    )
}

fun GeocodingDto.toGeocoding(): Geocoding {
    return Geocoding(
        geometry = results[0].geometry.toGeometry()
    )
}

fun GeometryDto.toGeometry(): Geometry {
    return Geometry(
        location = location
    )
}