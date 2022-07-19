package com.sursulet.realestatemanager.domain.windowmetrics

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowSizeType(): WindowMetrics {
    val config = LocalConfiguration.current
    return WindowMetrics(
        screenWidthInfo = when {
            config.screenWidthDp < 600 -> WindowMetrics.WindowSizeType.Compact
            config.screenWidthDp < 840 -> WindowMetrics.WindowSizeType.Medium
            else -> WindowMetrics.WindowSizeType.Expanded
        },
        screenHeightInfo = when {
            config.screenHeightDp < 480 -> WindowMetrics.WindowSizeType.Compact
            config.screenHeightDp < 900 -> WindowMetrics.WindowSizeType.Medium
            else -> WindowMetrics.WindowSizeType.Expanded
        },
        screenWidth = config.screenWidthDp.dp,
        screenHeight = config.screenHeightDp.dp
    )
}