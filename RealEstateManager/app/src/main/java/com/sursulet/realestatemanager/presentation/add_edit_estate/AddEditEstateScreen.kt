package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddEditScreen(navController: NavController) {

    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddEditScreenPreview() {
    AddEditScreen(navController = rememberNavController())
}