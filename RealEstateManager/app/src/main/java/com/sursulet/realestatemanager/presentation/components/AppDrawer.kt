package com.sursulet.realestatemanager.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Map
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.R
import com.sursulet.realestatemanager.domain.utils.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
    ) {
        DrawerHeader()
        DrawerBody(
            items = listOf(
                MenuItem(
                    id = "maps", title = "Maps",
                    contentDescription = "Go to the Map screen", icon = Icons.Default.Map
                ),
                MenuItem(
                    id = "loan", title = "Loan",
                    contentDescription = "Go to Loan Screen", icon = Icons.Default.AttachMoney
                )
            ),
            onItemClick = {
                when (it.id) {
                    "maps" -> navController.navigate(Screen.MapScreen.route)
                    "loan" -> navController.navigate(Screen.LoanScreen.route)
                }
                scope.launch { drawerState.close() }
            }
        )
    }
}

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 50.sp
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.contentDescription,
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    modifier = Modifier.weight(1f),
                    color = Color.White,
                    style = itemTextStyle
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDrawerPreview() {
    AppDrawer(
        navController = rememberNavController(),
        scope = rememberCoroutineScope(),
        drawerState = rememberScaffoldState().drawerState
    )
}