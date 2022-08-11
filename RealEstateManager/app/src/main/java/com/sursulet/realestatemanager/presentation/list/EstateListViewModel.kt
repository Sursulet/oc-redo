package com.sursulet.realestatemanager.presentation.list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.data.mappers.toEstateItemUi
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EstateListViewModel @Inject constructor(
    private val repository: EstateRepository
) : ViewModel() {

    var state by mutableStateOf(EstateListState())

    init {
        getEstates()
    }

    private fun getEstates() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)

            repository.getEstateItems()
                .collect { items ->
                    Log.d("PEACH", "getEstates: $items")
                    Log.d("PEACH", "selected: ${state.selected}")
                    state = state.copy(estates = items.map { it.toEstateItemUi() })
                }


        }
    }

    fun onEstateClicked(index: Int, estate: EstateItemUi) {
        Log.d("PEACH", "onEstateClicked: $index")

        state = state.copy(
            selected = estate,
            estates = state.estates.map {
                it.copy(
                    isSelected = if (estate == it) { Color.Blue } else Color.White
                )
            }
        )
    }
}