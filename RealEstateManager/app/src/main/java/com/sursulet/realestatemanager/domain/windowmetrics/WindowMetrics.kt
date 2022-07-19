package com.sursulet.realestatemanager.domain.windowmetrics

import androidx.compose.ui.unit.Dp

data class WindowMetrics(
    val screenWidthInfo: WindowSizeType,
    val screenHeightInfo: WindowSizeType,
    val screenWidth: Dp,
    val screenHeight: Dp,
) {
    sealed class WindowSizeType {
        object Compact: WindowSizeType()
        object Medium: WindowSizeType()
        object Expanded: WindowSizeType()
    }
}
