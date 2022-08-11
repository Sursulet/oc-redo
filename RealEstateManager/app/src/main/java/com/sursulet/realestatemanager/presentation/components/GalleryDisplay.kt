package com.sursulet.realestatemanager.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sursulet.realestatemanager.domain.model.Photo
import com.sursulet.realestatemanager.presentation.detail.components.PhotoItem

@Composable
fun GalleryDisplay(
    photos: List<Photo>
) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(photos) { photo ->
            PhotoItem(photo = photo)
        }
    }
}

@Preview
@Composable
fun GalleryDisplayPreview() {
    GalleryDisplay(
        photos = listOf(
            Photo(
                1, "Room",
                image = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888)
            ),
            Photo(
                2, "Bedroom",
                image = Bitmap.createBitmap(250, 250, Bitmap.Config.ARGB_8888)
            )
        )
    )
}