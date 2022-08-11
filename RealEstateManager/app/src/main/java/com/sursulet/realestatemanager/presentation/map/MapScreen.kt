package com.sursulet.realestatemanager.presentation.map

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column {
        Text(text = "Map Screen")
        //Text(text = "Status: ${state.connectivity}")
        //Text(text = navController.graph.startDestDisplayName)
        //navController.currentDestination?.let { it.route?.let { it1 -> Text(text = it1) } }
        //navController.currentDestination?.let { Text(text = it.navigatorName) }
    }
}