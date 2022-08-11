package com.sursulet.realestatemanager.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.maps.android.compose.GoogleMap

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
        state.estate?.let { estate ->

            id?.let { DetailTitle(text = it.toString()) }
            DetailTitle(text = "Media")
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                //contentPadding = PaddingValues(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(estate.photos) {
                    //PhotoCard(photo = it)
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
                        //Row(modifier = Modifier.fillMaxWidth()) {
                            //FeaturesDisplay(estate.surface, estate.rooms, estate.bathrooms, estate.bedrooms)
                        //}
                        //AddressDisplay(estate.address)
                        GoogleMap()
                    }
                } else {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.weight(1f)) {
                            //FeaturesDisplay(estate.surface, estate.rooms, estate.bathrooms, estate.bedrooms)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            //AddressDisplay(estate.address)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            GoogleMap()
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

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) { DetailScreen(id = 0L) }
}