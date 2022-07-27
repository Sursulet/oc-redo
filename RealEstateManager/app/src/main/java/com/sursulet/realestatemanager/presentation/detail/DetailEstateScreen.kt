package com.sursulet.realestatemanager.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.maps.android.compose.GoogleMap
import com.sursulet.realestatemanager.presentation.detail.components.PhotoCard

@Composable
fun DetailScreen(
    isCompactedScreen: Boolean = true,
    id: Long?,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp)
    ) {
        state.detailData?.let { estate ->

            id?.let { DetailTitle(text = it.toString()) }
            DetailTitle(text = "Media")
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                //contentPadding = PaddingValues(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(estate.gallery) {
                    PhotoCard(photo = it)
                }
            }

            DetailTitle(text = "Description")
            Text(
                text = estate.description,
                modifier = Modifier.fillMaxWidth()
            )

            BoxWithConstraints {
                if (isCompactedScreen) {
                    Column {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Column(modifier = Modifier.weight(1f)) {
                                ProprietyCard(
                                    Icons.Filled.Settings,
                                    "Surface",
                                    estate.surface
                                )
                                ProprietyCard(
                                    Icons.Filled.Home,
                                    "Number of rooms",
                                    estate.rooms
                                )
                                ProprietyCard(
                                    Icons.Filled.Home,
                                    "Number of bathrooms",
                                    estate.bathrooms
                                )
                                ProprietyCard(
                                    Icons.Rounded.Home,
                                    "Number of bedrooms",
                                    estate.bedrooms
                                )
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                ProprietyCard(
                                    Icons.Filled.LocationOn,
                                    "Location",
                                    estate.address
                                )
                            }
                        }
                        GoogleMap()
                    }
                } else {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            ProprietyCard(
                                Icons.Filled.Settings,
                                "Surface",
                                "56"
                            )
                            ProprietyCard(
                                Icons.Filled.Home,
                                "Number of rooms",
                                "56"
                            )
                            ProprietyCard(
                                Icons.Filled.Home,
                                "Number of bathrooms",
                                "56"
                            )
                            ProprietyCard(
                                Icons.Rounded.Home,
                                "Number of bedrooms",
                                "56"
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            ProprietyCard(
                                Icons.Filled.LocationOn,
                                "Location",
                                "78"
                            )
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            ProprietyCard(
                                Icons.Filled.LocationOn,
                                "Location",
                                "78"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DetailTitle(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        style = MaterialTheme.typography.body2
    )
}

@Composable
fun ProprietyCard(
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

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) { DetailScreen(id = 0L) }
}