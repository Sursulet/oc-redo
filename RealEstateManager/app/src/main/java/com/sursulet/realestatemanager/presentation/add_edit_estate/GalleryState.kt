package com.sursulet.realestatemanager.presentation.add_edit_estate

import com.sursulet.realestatemanager.domain.model.Photo

data class GalleryState(
    val photos: List<Photo> = emptyList()
)
