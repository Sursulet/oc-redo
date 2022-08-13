package com.sursulet.realestatemanager.presentation.map

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.sursulet.realestatemanager.domain.connectivity.ConnectivityTracker
import com.sursulet.realestatemanager.domain.location.LocationTracker
import com.sursulet.realestatemanager.domain.repository.AddressRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import com.sursulet.realestatemanager.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val connectivityTracker: ConnectivityTracker,
    private val locationTracker: LocationTracker,
    private val repository: AddressRepository,
    private val geocoder: GeocodingRepository
) : ViewModel() {

    var state by mutableStateOf(MapState())
        private set

    init {
        Log.d("mappy", "INITIALISATION: DEBUT")
        viewModelScope.launch {
            //val addresses = repository.getAddresses().first()
            //val result = geocoder.getCoordinates(address = "1600 Amphitheatre Parkway, Mountain View, CA")
            //val result = geocoder.getCoordinates(address = addresses[0].toString(", "))
            //val test = result.data
            //Log.d("mappy", "GEOCODER RESULT: $test")
            state = state.copy(
                marker = LatLng(40.771474,-73.963953)
            )
        }
    }

    fun isConnected() {
        Log.d("peach", "isConnected: IN")
        viewModelScope.launch {
            connectivityTracker.getCurrentConnectivity().collect { status ->
                when (status) {
                    ConnectivityTracker.Status.Available -> {
                        Log.d("peach", "isConnected: Status Available")
                        state = state.copy(
                            isLoading = true,
                            error = null
                        )

                        locationTracker.getCurrentLocation()?.let { location ->
                            repository.getAddresses().map { addresses ->
                                addresses.map { address ->
                                    Log.d(
                                        "peach", "isConnected: \n" +
                                                "location: ${location.longitude} , ${location.latitude} \n" +
                                                "address: ${address.toString(", ")}"
                                    )
                                    when (val result =
                                        geocoder.getCoordinates(address.toString(", "))) {
                                        is Resource.Error -> null
                                        is Resource.Success -> {
                                            Log.d("peach", "isConnected: ${result.data}")
                                            //result.data?.let { LatLng(it.latitude, it.longitude) }
                                        }
                                    }
                                }
                            }.collect {
                                Log.d("peach", "isConnected: $it")
                            }
                        }
                    }

                    else -> {
                        state = state.copy(
                            isLoading = false,
                            error = "Couldn't retrieve connectivity. Make sure to grant and enabled WIFI."
                        )
                    }
                }
            }
        }
    }

    private fun loadMap() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = geocoder.getCoordinates("")) {
                    is Resource.Error -> {
                        state = state.copy(
                            estates = emptyList(),
                            isLoading = false,
                            error = result.message
                        )
                    }
                    is Resource.Success -> {
                        //val distance = location.distanceTo(result.data)
                        state = state.copy(
                            estates = emptyList(),
                            isLoading = false,
                            error = null
                        )
                    }
                }
            }
            /*
            connectivityTracker.getCurrentConnectivity().collect { connectivity ->
                connectivity.let { status ->
                    Log.d("PEACH", "loadMap: $status")
                    //state = state.copy(connectivity = status)
                    when (status) {
                        ConnectivityTracker.Status.Available -> {
                            locationTracker.getCurrentLocation()?.let { location ->
                                repository.getAddresses().collect { list ->
                                    list.map { address ->
                                        geocoder.getCoordinates(address.toString()).let { result ->
                                            when (result) {
                                                is Resource.Success -> {
                                                    //MarkerUi(address.id, result.data)
                                                }
                                                is Resource.Error -> {
                                                    TODO()
                                                }
                                            }
                                        }
                                    }
                                }
                            } ?: kotlin.run {
                                state = state.copy(
                                    isLoading = false,
                                    error = "Couldn't retrieve location. Make sure to grant and enabled GPS."
                                )
                            }
                        }
                        else -> {
                            state = state.copy(
                                isLoading = false,
                                error = "Couldn't retrieve connectivity. Make sure to grant and enabled WIFI."
                            )
                        }
                    }
                }
            }

             */
        }
    }

    fun onAction(action: MapAction) {
        when (action) {
            is MapAction.ToggleFalloutMap -> {}
            is MapAction.OnInfoWindowLongClick -> {
                viewModelScope.launch {}
            }
            is MapAction.OnMapLongClick -> {
                viewModelScope.launch { }
            }
        }
    }
}