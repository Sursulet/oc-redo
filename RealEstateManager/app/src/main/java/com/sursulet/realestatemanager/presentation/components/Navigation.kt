package com.sursulet.realestatemanager.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sursulet.realestatemanager.domain.utils.Screen
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics
import com.sursulet.realestatemanager.presentation.add_edit.AddEditScreen
import com.sursulet.realestatemanager.presentation.detail.DetailScreen
import com.sursulet.realestatemanager.presentation.list.ListScreen
import com.sursulet.realestatemanager.presentation.loan.LoanScreen
import com.sursulet.realestatemanager.presentation.map.MapScreen

@Composable
fun Navigation(windowSizeType: WindowMetrics) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            if (windowSizeType.screenWidthInfo is WindowMetrics.WindowSizeType.Compact) {
                ListScreen(navController = navController)
            } else {
                DetailScreen(string = "HELLO!!! HIHIHI")
            /*MainScreen(navController = navController)*/
            }
        }
        composable(
            route = Screen.DetailScreen.route + "/{estate_id}",
            arguments = listOf(
                navArgument("estate_id") {
                    type = NavType.StringType
                    defaultValue = "NULL"
                    nullable = true
                }
            )) { entry ->
            DetailScreen(entry.arguments?.getString("estate_id"))
        }
        composable(route = Screen.AddEditScreen.route) { AddEditScreen(navController = navController) }
        composable(route = Screen.MapScreen.route) { MapScreen(navController = navController) }
        composable(route = Screen.LoanScreen.route) { LoanScreen(navController = navController) }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate(Screen.DetailScreen.withArgs(text))
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "Go to Detail")
        }
    }
}