package com.sursulet.realestatemanager.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.di.DefaultDispatcher
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
    private val estateRepository: EstateRepository,
    private val repository: GeocodingRepository,
) : ViewModel() {

    var state by mutableStateOf(DetailState())
        private set

    init {
        savedStateHandle.get<Long>("estate_id")?.let { id ->
            getEstate(id)
        }
    }

    private fun getEstate(id: Long) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            estateRepository.getEstateWithPhotosById(id)
                .also { state = state.copy(estate = it) }
        }
    }
}