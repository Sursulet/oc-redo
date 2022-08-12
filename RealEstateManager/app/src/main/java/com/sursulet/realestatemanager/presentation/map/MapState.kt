package com.sursulet.realestatemanager.presentation.map

import com.google.maps.android.compose.MapProperties
import com.sursulet.realestatemanager.domain.model.Address

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isFalloutMap: Boolean = false,
    val estates: List<Address> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
