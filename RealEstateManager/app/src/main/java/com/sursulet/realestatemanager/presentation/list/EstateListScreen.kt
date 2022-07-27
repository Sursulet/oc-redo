package com.sursulet.realestatemanager.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sursulet.realestatemanager.domain.utils.Screen

@Composable
fun EstateListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: EstateListViewModel = hiltViewModel()
) {
    val state = viewModel.state//.value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(state.estates) {
            EstateCard(
                estate = it,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { navController.navigate(Screen.DetailScreen.withArgs(1L)) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    EstateListScreen(navController = rememberNavController())
}