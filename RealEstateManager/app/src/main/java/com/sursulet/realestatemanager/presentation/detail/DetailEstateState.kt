package com.sursulet.realestatemanager.presentation.detail

import com.sursulet.realestatemanager.domain.model.Estate

data class DetailState(
    val estate: Estate? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
