package com.sursulet.realestatemanager.presentation.list

data class EstateListState(
    val estates: List<EstateItemUi> = emptyList(),
    val selected: EstateItemUi? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
