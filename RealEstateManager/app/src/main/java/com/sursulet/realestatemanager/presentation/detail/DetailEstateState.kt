package com.sursulet.realestatemanager.presentation.detail

import com.sursulet.realestatemanager.domain.model.DetailData

data class DetailState(
    val detailData: DetailData? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
