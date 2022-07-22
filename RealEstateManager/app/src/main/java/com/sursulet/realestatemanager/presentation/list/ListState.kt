package com.sursulet.realestatemanager.presentation.list

import com.sursulet.realestatemanager.domain.model.EstateData

data class ListState(
    val estates: List<EstateData> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
