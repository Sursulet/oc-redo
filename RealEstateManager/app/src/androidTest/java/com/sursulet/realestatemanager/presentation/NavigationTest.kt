package com.sursulet.realestatemanager.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.utils.Screen
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()//createComposeRule()

    @get:Rule
    val hiltRule = HiltAndroidRule(this)

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
    fun navigateToAddScreen() {
        composeTestRule
            .onNodeWithContentDescription(Screen.MapScreen.route)
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