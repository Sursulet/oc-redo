package com.sursulet.realestatemanager.data.mappers

import com.sursulet.realestatemanager.data.local.EstateItemDto
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.Estate
import com.sursulet.realestatemanager.domain.model.EstateItem
import com.sursulet.realestatemanager.presentation.list.EstateItemUi
import java.time.LocalDate

fun EstateItemDto.toEstateItem(): EstateItem {
    return EstateItem(
        id = id,
        photo = photo,
        type = type,
        price = price,
        city = city
    )
}

fun EstateItem.toEstateItemUi(): EstateItemUi {
    return EstateItemUi(
        id = id,
        photo = photo,
        type = type,
        price = price,
        city = city
    )
}

fun EstateWithPhotos.toEstate(): Estate {
    return Estate(
        photos = photos.map { it.toPhoto() },
        type = estate.type,
        price = estate.price,
        surface = estate.surface,
        rooms = estate.rooms,
        bathrooms = estate.rooms,
        bedrooms = estate.rooms,
        description = estate.description,
        address = estate.address,
        nearby = estate.nearby,
        isAvailable = estate.isAvailable,
        created = LocalDate.now(),//estate.created,
        saleTimestamp = LocalDate.now(),//estate.saleTimestamp,
        agent = estate.agent
    )
}