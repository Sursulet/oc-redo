package com.sursulet.realestatemanager.presentation.map

import android.Manifest
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.sursulet.realestatemanager.domain.model.Address

@Composable
fun MapScreen(
    navController: NavController,
    viewModel: MapViewModel = hiltViewModel()
) {
    val locationPermissionRequest = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                Log.d("peach", "MapScreen: isGRANTED")
                //viewModel.isConnected()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                Log.d("peach", "MapScreen: YEH!YEH! isGRANTED")
            }
            else -> {
                Log.d("peach", "MapScreen: !!!isGRANTED")
            }
        }
    }

    LaunchedEffect(key1 = true) {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }

    val state = viewModel.state
    val uiSettings = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }


    /*Column {
        Text(text = "Map Screen")
        Log.d("peach", "MapScreen: IN MAP SCREEN COLUMN")

        //scope.launch { locationPermissionRequest.launch(permissions) }

        //Text(text = "Status: ${state.connectivity}")
        //Text(text = navController.graph.startDestDisplayName)
        //navController.currentDestination?.let { it.route?.let { it1 -> Text(text = it1) } }
        //navController.currentDestination?.let { Text(text = it.navigatorName) }
    }*/

    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = viewModel.state.properties,
        uiSettings = uiSettings,
        onMapClick = {}
    ) {
        viewModel.state.estates.forEach { estate ->
            Marker(
                state = MarkerState(position = estate),
                onClick = {
                    it.showInfoWindow()
                    true
                },
                icon = BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_GREEN
                )
            )
        }
    }
}