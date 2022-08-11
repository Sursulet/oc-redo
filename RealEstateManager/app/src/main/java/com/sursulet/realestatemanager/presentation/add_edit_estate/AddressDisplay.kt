package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AddressForm(
    street: String,
    extras: String,
    city: String,
    state: String,
    zip: String,
) {
    Column(){
        InputForm(
            text = street,
            modifier = Modifier.fillMaxWidth(),
            label = "street"
        )
        InputForm(
            text = extras,
            modifier = Modifier.fillMaxWidth(),
            label = "extras"
        )
        InputForm(
            text = city,
            modifier = Modifier.fillMaxWidth(),
            label = "city"
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InputForm(
                text = state,
                modifier = Modifier.weight(1f),
                label = "state"
            )
            InputForm(
                text = zip,
                modifier = Modifier.weight(1f),
                label = "zip"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddressFormPreview() {
    AddressForm(
        street = "hjkl",
        extras = "hjkghl",
        city = "ghjk",
        state = "fghjkl",
        zip = "fghjk"
    )
}