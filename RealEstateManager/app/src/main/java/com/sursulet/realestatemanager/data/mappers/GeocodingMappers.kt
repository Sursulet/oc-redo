package com.sursulet.realestatemanager.data.mappers

import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.data.remote.dto.GeocodingDto
import com.sursulet.realestatemanager.data.remote.dto.GeometryDto
import com.sursulet.realestatemanager.domain.model.Geocoding
import com.sursulet.realestatemanager.domain.model.Geometry


fun GeocodingDto.toLatLng(): LatLng {
    return LatLng(
        geometry.location.lat,
        geometry.location.lng
    )
}

fun GeocodingDto.toGeocoding(): Geocoding {
    return Geocoding(
        geometry = geometry.toGeometry()
    )
}

fun GeometryDto.toGeometry(): Geometry {
    return Geometry(
        location = location
    )
}