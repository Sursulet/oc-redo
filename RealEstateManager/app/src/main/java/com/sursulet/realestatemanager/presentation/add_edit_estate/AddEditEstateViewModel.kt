package com.sursulet.realestatemanager.presentation.add_edit_estate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddEditEstateViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val estateRepository: EstateRepository,
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _estateType = mutableStateOf(EstateTextFieldState())
    private val _estatePrice = mutableStateOf(EstateTextFieldState())
    private val _estateSurface = mutableStateOf(EstateTextFieldState())
    private val _estateRooms = mutableStateOf(EstateTextFieldState())
    private val _estateDescription = mutableStateOf(EstateTextFieldState())
    private val _estatePhotos = mutableStateOf(EstateTextFieldState())
    private val _estateAddress = mutableStateOf(EstateTextFieldState())
    private val _estateNearby = mutableStateOf(EstateTextFieldState())
    private val _estateStatus = mutableStateOf(EstateTextFieldState())

    val estateType: State<EstateTextFieldState> = _estateType

    init {
        /*
        savedStateHandle.get<Long>("estateId")?.let { id ->
            //if (id) {
                viewModelScope.launch {
                    repository.getEstateWithPhotosById(id).also { detail ->
                        _estateType.value = estateType.value.copy(
                            text = detail.estate.type
                        )
                    }
                }
            //}
        }

         */
    }
}