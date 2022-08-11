package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddEditScreen(
    //navController: NavController,
    //id: Long?,
    viewModel: AddEditEstateViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Created on $state",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End
        )

        InputForm(
            text = "state.price.text",
            modifier = Modifier.fillMaxWidth(),
            label = "price",
            keyboardType = KeyboardType.Decimal
        )

        /*LazyVerticalGrid(
            columns = GridCells.Adaptive(128.dp)
        ) {
            items(state.gallery) { photo ->
                Box {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(text = photo.toString()) //PhotoCard(photo = photo)
                    }
                    Box(modifier = Modifier.align(Alignment.TopEnd)) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.RemoveCircle,
                                contentDescription = "Delete photo"
                            )
                        }
                    }
                }
            }
        }*/

        AddressForm("", "", "", "", "")

        FeaturesForm()

        InputForm(
            text = "",
            modifier = Modifier.height(160.dp),
            label = "description"
        )

        InputForm(
            text = "",
            label = "nearby"
        )

        InputForm(
            text = "",
            label = "agent"
        )

    }

}

@Preview(showBackground = true)
@Composable
fun AddEditScreenPreview() {
    AddEditScreen(
        //navController = rememberNavController(),
        //id = null

    )
}