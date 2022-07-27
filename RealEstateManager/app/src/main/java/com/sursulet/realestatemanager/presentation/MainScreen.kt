package com.sursulet.realestatemanager.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.presentation.detail.DetailScreen
import com.sursulet.realestatemanager.presentation.list.EstateListScreen

@Composable
fun MainScreen(
    navController: NavHostController,
    isCompactedScreen: Boolean,
    modifier: Modifier = Modifier
) {
    if (isCompactedScreen) {
        EstateListScreen(navController = navController, modifier = Modifier.fillMaxSize())
    } else {
        Row(modifier.fillMaxSize()) {
            Column(modifier.weight(1f)) { EstateListScreen(navController = navController) }
            Column(modifier.weight(2f)) { DetailScreen(id = 13L) }
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController(), isCompactedScreen = true)
}