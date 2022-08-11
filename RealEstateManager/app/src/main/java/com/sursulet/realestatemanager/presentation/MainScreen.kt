package com.sursulet.realestatemanager.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics
import com.sursulet.realestatemanager.presentation.components.AppBar
import com.sursulet.realestatemanager.presentation.components.AppDrawer
import kotlinx.coroutines.launch

@Composable
fun MainScreen(widthSizeType: WindowMetrics.WindowSizeType) {
    val navController = rememberNavController()
    val isCompactedScreen = widthSizeType == WindowMetrics.WindowSizeType.Compact
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch { scaffoldState.drawerState.open() }
                                        },
                navController = navController,
                isCompactedScreen = isCompactedScreen
            )
                 },
        drawerContent = {
            AppDrawer(
                scope = scope,
                drawerState = scaffoldState.drawerState,
                navController = navController
            )
                        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen
    ) { innerPadding ->
        Navigation(
            navController = navController,
            isCompactedScreen = isCompactedScreen,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RealEstateManagerScreenPreview() {
    MainScreen(widthSizeType = WindowMetrics.WindowSizeType.Compact)
}