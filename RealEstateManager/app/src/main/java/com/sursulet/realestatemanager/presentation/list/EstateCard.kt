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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sursulet.realestatemanager.R
import com.sursulet.realestatemanager.domain.model.EstateData
import java.text.NumberFormat
import java.util.*

@Composable
fun EstateCard(
    modifier: Modifier,
    estate: EstateData
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.background(Color.Cyan)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Real estate photo",
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(estate.type, style = MaterialTheme.typography.subtitle2)
            Text(text = estate.city, style = MaterialTheme.typography.caption)
            Text(
                text = estate.price,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EstateCardPreview() {
    EstateCard(
        modifier = Modifier,
        EstateData(
            id = 1,
            photo = Bitmap.createBitmap(200,200,Bitmap.Config.RGB_565),
            type = "Flat",
            city = "Paris",
            price = NumberFormat.getNumberInstance(Locale.US).format(123000f)
        )
    )
}