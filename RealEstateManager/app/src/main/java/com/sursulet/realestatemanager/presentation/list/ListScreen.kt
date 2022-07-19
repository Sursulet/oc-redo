package com.sursulet.realestatemanager.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.utils.Screen

@Composable
fun ListScreen(navController: NavController) {
    LazyColumn {
        items(10) {
            EstateCard(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(Screen.DetailScreen.route) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    ListScreen(navController = rememberNavController())
}