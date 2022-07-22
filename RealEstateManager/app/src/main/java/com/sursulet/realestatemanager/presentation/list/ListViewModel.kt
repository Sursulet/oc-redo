package com.sursulet.realestatemanager.presentation.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: EstateRepository
): ViewModel() {

    var state by mutableStateOf(ListState())

    init {
        getEstates()
    }

    private fun getEstates() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            repository.getEstates()
                .collect { result ->
                    //when(result) {}
                }
        }
    }
}