package com.sursulet.realestatemanager.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics

@Composable
fun RealEstateManagerApp(widthSizeType: WindowMetrics.WindowSizeType) {
    val navController = rememberNavController()
    val isCompactedScreen = widthSizeType == WindowMetrics.WindowSizeType.Compact

    Scaffold(modifier = Modifier) { innerPadding ->
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
    RealEstateManagerApp(widthSizeType = WindowMetrics.WindowSizeType.Compact)
}