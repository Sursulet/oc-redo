package com.sursulet.realestatemanager.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sursulet.realestatemanager.domain.utils.Screen

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
        composable(Screen.MainScreen.route) {
            MainScreen(
                isCompactedScreen,
                modifier.semantics { contentDescription = Screen.MainScreen.route }
            )
        }
    }
}