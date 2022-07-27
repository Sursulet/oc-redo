package com.sursulet.realestatemanager.presentation.detail.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sursulet.realestatemanager.data.local.Photo

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    photo: Photo
) {
    Card(
        modifier = modifier
            .size(width = 140.dp, height = 140.dp),
        shape = RoundedCornerShape(0.dp),
        elevation = 5.dp
    ) {
        Box(modifier = modifier.height(100.dp)) {
            Image(
                bitmap = photo.image.asImageBitmap(),//painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "Photo",
                    color = Color.White,
                    //TextAlign = TextAlign,
                    modifier = Modifier
                        .background(color = Color.Black.copy(alpha = 0.5f))
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoCardPreview() {
    PhotoCard(
        photo = Photo(
            id = 1, estateId = 1,
            title = "Room",
            image = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
        )
    )
}