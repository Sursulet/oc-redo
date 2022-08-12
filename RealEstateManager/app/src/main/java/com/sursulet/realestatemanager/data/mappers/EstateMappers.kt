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
        type = estate.features.type,
        price = estate.features.price,
        surface = estate.features.surface,
        rooms = estate.features.rooms,
        bathrooms = estate.features.rooms,
        bedrooms = estate.features.rooms,
        description = estate.features.description,
        address = estate.address.toAddress(),
        nearby = estate.features.nearby,
        isAvailable = estate.features.isAvailable,
        created = estate.features.created,
        saleTimestamp = estate.features.saleTimestamp,
        agent = estate.features.agent
    )
}