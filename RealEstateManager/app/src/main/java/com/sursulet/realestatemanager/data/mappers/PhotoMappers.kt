package com.sursulet.realestatemanager.data.mappers

import com.sursulet.realestatemanager.data.local.PhotoDto
import com.sursulet.realestatemanager.domain.model.Photo

fun PhotoDto.toPhoto(): Photo {
    return Photo(id = id, title = title, image = image)
}

fun Photo.toPhotoDto(): PhotoDto {
    return PhotoDto(id = id, estateId = 1, title = title, image = image)
}