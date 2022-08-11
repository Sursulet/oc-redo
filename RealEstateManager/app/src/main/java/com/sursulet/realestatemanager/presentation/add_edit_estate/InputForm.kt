package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputForm(
    text: String,
    modifier: Modifier = Modifier,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = false
) {
    OutlinedTextField(
        value = text,
        onValueChange = {},
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = singleLine
    )
}

@Preview(showBackground = true)
@Composable
fun InputFormPreview() {
    InputForm(text = "", label = "label")
}