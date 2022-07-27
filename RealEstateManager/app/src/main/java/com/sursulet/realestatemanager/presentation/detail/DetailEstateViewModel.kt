package com.sursulet.realestatemanager.presentation.detail

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val estateRepository: EstateRepository,
    private val repository: GeocodingRepository,
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    init {
        CoroutineScope(Dispatchers.IO).launch {
            //val estateId = savedStateHandle.get<String>("estate_id") ?: return@launch
            state = state.copy(isLoading = true)

            savedStateHandle.get<Long>("estate_id")?.let { id ->
                Log.d("PEACH", "ID: $id")
                val result = estateRepository.getEstateWithPhotosById(id)
                state = state.copy(detailData = result)
            }
        }
    }
}