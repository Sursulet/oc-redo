package com.sursulet.realestatemanager.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun EstateListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: EstateListViewModel = hiltViewModel()
) {
    val state = viewModel.state//.value

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        itemsIndexed(state.estates) { index, estate ->
            EstateCard(
                estate = estate,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        viewModel.onEstateClicked(index, estate)
                        //navController.navigate(Screen.DetailScreen.withArgs(it.id))
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    EstateListScreen(navController = rememberNavController())
}