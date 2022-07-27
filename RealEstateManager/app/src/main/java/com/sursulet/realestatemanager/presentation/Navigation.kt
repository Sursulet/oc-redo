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
import com.sursulet.realestatemanager.presentation.detail.DetailScreen

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
            MainScreen(
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
    }
}