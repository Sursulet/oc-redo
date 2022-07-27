package com.sursulet.realestatemanager.presentation.map

import androidx.lifecycle.ViewModel
import com.sursulet.realestatemanager.domain.location.LocationTracker
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val locationTracker: LocationTracker
): ViewModel() {
}