package com.sursulet.realestatemanager.presentation.list

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sursulet.realestatemanager.R

@Composable
fun EstateCard(
    modifier: Modifier,
    estate: EstateItemUi
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(estate.isSelected)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Real estate photo",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.padding(16.dp)) {
            Text(estate.type, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = estate.city, fontSize = 24.sp)
            Text(
                text = estate.price.toString(),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h4
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EstateCardPreview() {
    EstateCard(
        modifier = Modifier,
        EstateItemUi(
            id = 1,
            photo = Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
            type = "Flat",
            city = "Paris",
            price = 1f
        )
    )
}