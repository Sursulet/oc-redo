package com.sursulet.realestatemanager.data.mappers

import com.sursulet.realestatemanager.data.local.EstateItemDto
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.Estate
import com.sursulet.realestatemanager.domain.model.EstateItem
import com.sursulet.realestatemanager.presentation.list.EstateItemUi

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
        type = estate.estate.type,
        price = estate.estate.price,
        surface = estate.estate.surface,
        rooms = estate.estate.rooms,
        bathrooms = estate.estate.rooms,
        bedrooms = estate.estate.rooms,
        description = estate.estate.description,
        address = estate.address.toAddress(),
        nearby = estate.estate.nearby,
        isAvailable = estate.estate.isAvailable,
        created = estate.estate.created,
        saleTimestamp = estate.estate.saleTimestamp,
        agent = estate.estate.agent
    )
}