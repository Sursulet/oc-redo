package com.sursulet.realestatemanager.presentation.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.R
import com.sursulet.realestatemanager.domain.utils.Screen

@Composable
fun AppBar(
    onNavigationIconClick: () -> Unit,
    navController: NavHostController,
    isCompactedScreen: Boolean
) {
    //val currentRouteState = navController.currentBackStackEntryAsState()
    val currentRoute = navController.currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)

    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Toggle menu"
                )
            }
        },
        actions = {
            IconButton(
                onClick = {
                    navController.navigate(Screen.AddEditScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add a real estate"
                )
            }

            if (currentRoute.value?.destination?.route == (Screen.DetailScreen.route + "/{estate_id}")) {
                IconButton(
                    onClick = {
                        navController.navigate(
                            Screen.AddEditScreen.route + "?estate_id=" +
                                    currentRoute.value?.arguments?.get("estate_id"))
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit real estate"
                    )
                }
            }

            IconButton(
                onClick = { navController.navigate(Screen.SearchScreen.route) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search real estate"
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar(
        onNavigationIconClick = { },
        navController = rememberNavController(),
        isCompactedScreen = true
    )
}