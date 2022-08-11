package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FeaturesForm() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InputForm(
                text = "",
                modifier = Modifier.weight(1f),
                label = "surface"
            )
            InputForm(
                text = "",
                modifier = Modifier.weight(1f),
                label = "number of rooms"
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InputForm(
                text = "",
                modifier = Modifier.weight(1f),
                label = "number of bedrooms"
            )
            InputForm(
                text = "",
                modifier = Modifier.weight(1f),
                label = "number of bathrooms"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeaturesFormPreview() {
    FeaturesForm()
}