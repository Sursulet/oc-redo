package com.sursulet.realestatemanager.presentation.map

import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.domain.model.Estate

sealed class MapAction {
    object ToggleFalloutMap : MapAction()
    data class OnMapLongClick(val latLng: LatLng) : MapAction()
    data class OnInfoWindowLongClick(val estate: Estate) : MapAction()
}
