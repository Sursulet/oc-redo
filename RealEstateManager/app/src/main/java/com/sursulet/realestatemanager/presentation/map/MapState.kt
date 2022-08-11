package com.sursulet.realestatemanager.presentation.map

import com.sursulet.realestatemanager.domain.model.Address

data class MapState(
    val estates: List<Address> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
