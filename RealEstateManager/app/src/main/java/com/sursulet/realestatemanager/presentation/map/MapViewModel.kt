package com.sursulet.realestatemanager.presentation.map

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.domain.connectivity.ConnectivityTracker
import com.sursulet.realestatemanager.domain.location.LocationTracker
import com.sursulet.realestatemanager.domain.repository.AddressRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import com.sursulet.realestatemanager.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
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
        loadMap()
    }

    private fun loadMap() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )

            connectivityTracker.getCurrentConnectivity().collect { connectivity ->
                connectivity.let { status ->
                    Log.d("PEACH", "loadMap: $status")
                    state = state.copy(connectivity = status)
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
        }
    }
}