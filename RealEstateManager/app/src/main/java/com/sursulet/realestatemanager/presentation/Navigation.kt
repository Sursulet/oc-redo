package com.sursulet.realestatemanager.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sursulet.realestatemanager.domain.utils.Screen
import com.sursulet.realestatemanager.presentation.add_edit_estate.AddEditScreen
import com.sursulet.realestatemanager.presentation.detail.DetailScreen
import com.sursulet.realestatemanager.presentation.loan.LoanScreen
import com.sursulet.realestatemanager.presentation.map.MapScreen
import com.sursulet.realestatemanager.presentation.search.SearchScreen

@Composable
fun Navigation(
    navController: NavHostController,
    isCompactedScreen: Boolean,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route,
        modifier = modifier
    ) {
        composable(route = Screen.MainScreen.route) {
            MainDisplay(
                navController = navController,
                isCompactedScreen = isCompactedScreen,
                modifier = modifier.semantics { contentDescription = Screen.MainScreen.route }
            )
        }
        composable(
            route = "detail_screen/{estate_id}",
            arguments = listOf(navArgument("estate_id") { type = NavType.LongType })
        ) { backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getLong("estate_id"))
        }
        composable(
            route = "add_edit_screen?estate_id={estate_id}",
            arguments = listOf(
                navArgument("estate_id") {
                    type = NavType.LongType
                    defaultValue = -1
                }
            )
        ) { backStackEntry ->
            AddEditScreen(
                //navController = navController,
                //id = backStackEntry.arguments?.getLong("estate_id")
            )
        }
        composable(route = Screen.SearchScreen.route) {
            SearchScreen()
        }
        composable(route = Screen.MapScreen.route) {
            MapScreen(navController = navController)
        }
        composable(route = Screen.LoanScreen.route) {
            LoanScreen(navController = navController)
        }
    }
}