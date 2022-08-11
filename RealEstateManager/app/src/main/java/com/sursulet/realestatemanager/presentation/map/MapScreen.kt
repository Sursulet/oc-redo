package com.sursulet.realestatemanager.presentation.map

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MapScreen(navController: NavController) {
    Column {
        Text(text = "Map Screen")
        Text(text = navController.graph.startDestDisplayName)
        navController.currentDestination?.let { it.route?.let { it1 -> Text(text = it1) } }
        navController.currentDestination?.let { Text(text = it.navigatorName) }
    }
}