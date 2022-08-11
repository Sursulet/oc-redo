package com.sursulet.realestatemanager.presentation.add_edit_estate

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sursulet.realestatemanager.domain.model.Photo

@Composable
fun AddEditPhotosScreen(
    modifier: Modifier = Modifier,
    photos: List<Photo>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(imageVector = Icons.Outlined.PhotoCamera, contentDescription = "")
        LazyRow {
            items(photos) { photo ->
                //PhotoCard(photo = photo)
            }
        }
    }
}

@Preview
@Composable
fun AddEditPhotosScreenPreview() {
    AddEditPhotosScreen(
        photos = listOf(
            Photo(
                id = 1, //estateId = 1,
                title = "Room",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565)
            ),
            Photo(
                id = 1, //estateId = 1,
                title = "Room",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565)
            )
        )
    )
}