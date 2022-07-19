package com.sursulet.realestatemanager.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sursulet.realestatemanager.domain.windowmetrics.WindowMetrics
import com.sursulet.realestatemanager.domain.windowmetrics.rememberWindowSizeType
import com.sursulet.realestatemanager.presentation.components.AppBar
import com.sursulet.realestatemanager.presentation.components.AppDrawer
import com.sursulet.realestatemanager.presentation.detail.DetailScreen
import com.sursulet.realestatemanager.presentation.ui.theme.RealEstateManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealEstateManagerTheme {
                val windowSizeType = rememberWindowSizeType()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { AppBar(onNavigationIconClick = {}) },
                    drawerContent = { AppDrawer(items = emptyList(), onItemClick = {}) }
                ) { padding ->
                    if (windowSizeType.screenWidthInfo is WindowMetrics.WindowSizeType.Compact) {
                        //ListScreen()
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(10) { item ->
                                Button(
                                    onClick = {
                                        //navController.navigate(Screen.DetailScreen.withArgs("$item"))
                                    }//,
                                    //modifier = Modifier.align(Alignment.Vertical.Top)
                                ) { Text(text = "Go to Detail") }
                            }
                        }
                    } else {
                        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                        ) {
                            LazyColumn(modifier = Modifier.weight(1f)) {
                                items(10) { item ->
                                    Button(
                                        onClick = {
                                            //navController.navigate(Screen.DetailScreen.withArgs("$item"))
                                        }//,
                                        //modifier = Modifier.align(Alignment.Vertical.Top)
                                    ) { Text(text = "Go to Detail") }
                                }
                            }
                            Column(modifier = Modifier.weight(1f)) {
                                DetailScreen(string = "")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        val gameList = listOf(
            "Horizon",
            "Uncharted",
            "Resident evil",
            "Red dead redemption",
            "Grand theft auto",
            "Assassin's creed",
            "Battlefield",
            "Fora horizon"
        )
        LazyRow {
            items(gameList) { item ->
                Text(text = item)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RealEstateManagerTheme {
        Greeting()
    }
}