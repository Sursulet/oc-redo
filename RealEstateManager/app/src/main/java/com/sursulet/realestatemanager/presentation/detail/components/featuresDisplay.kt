package com.sursulet.realestatemanager.presentation.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.HotTub
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.SettingsOverscan
import androidx.compose.material.icons.rounded.Hotel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FeaturesDisplay(
    surface: String,
    rooms: String,
    bathrooms: String,
    bedrooms: String
) {
        FeaturesCard(
            Icons.Filled.SettingsOverscan,
            "Surface",
            surface
        )
        FeaturesCard(
            Icons.Filled.Home,
            "Number of rooms",
            rooms
        )
        FeaturesCard(
            Icons.Filled.HotTub,
            "Number of bathrooms",
            bathrooms
        )
        FeaturesCard(
            Icons.Rounded.Hotel,
            "Number of bedrooms",
            bedrooms
        )
}

@Composable
fun AddressDisplay(address: String) {
    FeaturesCard(
        Icons.Filled.LocationOn,
        "Location",
        address
    )
}

@Composable
fun FeaturesCard(
    icon: ImageVector,
    title: String,
    value: String
) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = title
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = title)
            Text(
                text = value,
                modifier = Modifier.padding(start = 8.dp),
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview
@Composable
fun FeaturesDisplayPreview() {
    Column { FeaturesDisplay(surface = "27", rooms = "1", bathrooms = "1", bedrooms = "0") }
}