package com.sursulet.realestatemanager.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.utils.Screen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: NavHostController

    @Before
    fun setupNavigation() {
        composeTestRule.setContent {
            navController = rememberNavController()
            Navigation(
                navController = navController,
                isCompactedScreen = true
            )
        }
    }

    @Test
    fun navigation() {
        composeTestRule
            .onNodeWithContentDescription(Screen.MainScreen.route)
            .assertIsDisplayed()
    }

    @Test
    fun navigation_navigateToDetailScreen_viaUI() {
        composeTestRule
            .onNodeWithContentDescription("")
            .performClick()
        composeTestRule
            .onNodeWithContentDescription("")
            .assertIsDisplayed()
    }
}