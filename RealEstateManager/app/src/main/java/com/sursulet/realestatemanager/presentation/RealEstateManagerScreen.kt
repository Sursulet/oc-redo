package com.sursulet.realestatemanager.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.utils.Screen
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics
import com.sursulet.realestatemanager.presentation.components.AppBar
import com.sursulet.realestatemanager.presentation.components.AppDrawer
import com.sursulet.realestatemanager.presentation.components.MenuItem
import kotlinx.coroutines.launch

@Composable
fun RealEstateManagerScreen(
    navController: NavController,
    windowSizeType: WindowMetrics
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                onNavigationIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            )
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            AppDrawer(
                items = listOf(
                    MenuItem(
                        id = "loan",
                        title = "Loan",
                        contentDescription = "Loan",
                        icon = Icons.Rounded.ShoppingCart
                    )
                ),
                onItemClick = {
                    when (it.id) {
                        "map" -> navController.navigate(Screen.MapScreen.route)
                        "loan" -> navController.navigate(Screen.LoanScreen.route)
                    }
                }
            )
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item { Text(text = "Yu Hi!") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RealEstateManagerScreenPreview() {
    RealEstateManagerScreen(
        navController = rememberNavController(),
        windowSizeType = WindowMetrics(
            screenWidthInfo = WindowMetrics.WindowSizeType.Compact,
            screenHeightInfo = WindowMetrics.WindowSizeType.Compact,
            screenWidth = 380.dp,
            screenHeight = 380.dp
        )
    )
}