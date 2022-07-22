package com.sursulet.realestatemanager.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sursulet.realestatemanager.presentation.detail.DetailScreen
import com.sursulet.realestatemanager.presentation.list.ListScreen

@Composable
fun MainScreen(
    isCompactedScreen: Boolean,
    modifier: Modifier = Modifier
) {
    if (isCompactedScreen) {
        ListScreen()
    } else {
        Row(modifier.fillMaxSize()) {
            Column(modifier.weight(1f)) { ListScreen() }
            Column(modifier.weight(2f)) { DetailScreen("yy") }
        }
    }
}