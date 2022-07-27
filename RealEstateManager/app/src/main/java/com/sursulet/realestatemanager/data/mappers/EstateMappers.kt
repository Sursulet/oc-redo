package com.sursulet.realestatemanager.data.mappers

import android.graphics.Bitmap
import com.sursulet.realestatemanager.data.local.EstateItemView
import com.sursulet.realestatemanager.data.local.EstateWithPhotos
import com.sursulet.realestatemanager.domain.model.DetailData
import com.sursulet.realestatemanager.domain.model.EstateData
import java.text.NumberFormat
import java.util.*

fun EstateItemView.toEstateData(): EstateData {
    return EstateData(
        id = id,
        photo = Bitmap.createBitmap(16,16,Bitmap.Config.ARGB_8888),
        type = type,
        city = city,
        price = NumberFormat.getNumberInstance(Locale.US).format(price)
    )
}

fun EstateWithPhotos.toEstateDetailData(): DetailData {
    return DetailData(
        gallery = photos,
        description = estate.description,
        surface = estate.surface.toString(),
        rooms = estate.rooms.toString(),
        bathrooms = estate.rooms.toString(),
        bedrooms = estate.rooms.toString(),
        address = estate.address.toString()
    )
}