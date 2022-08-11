package com.sursulet.realestatemanager.presentation.add_edit_estate

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.data.local.Address
import com.sursulet.realestatemanager.data.local.EstateDto
import com.sursulet.realestatemanager.data.local.PhotoDto
import com.sursulet.realestatemanager.data.mappers.toPhoto
import com.sursulet.realestatemanager.data.mappers.toPhoto
import com.sursulet.realestatemanager.data.mappers.toPhotoDto
import com.sursulet.realestatemanager.di.IoDispatcher
import com.sursulet.realestatemanager.domain.model.AddEditEstateUi
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditEstateViewModel @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    savedStateHandle: SavedStateHandle,
    private val estateRepository: EstateRepository,
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private val _estateType = mutableStateOf(EstateTextFieldState())
    private val _estatePrice = mutableStateOf(EstateTextFieldState())
    private val _estateSurface = mutableStateOf(EstateTextFieldState())
    private val _estateRooms = mutableStateOf(EstateTextFieldState())
    private val _estateDescription = mutableStateOf(EstateTextFieldState())
    private val _estatePhotos = mutableStateOf(GalleryState())
    private val _estateAddress = mutableStateOf(EstateTextFieldState())
    private val _estateStreet = mutableStateOf(EstateTextFieldState())
    private val _estateExtras = mutableStateOf(EstateTextFieldState())
    private val _estateCity = mutableStateOf(EstateTextFieldState())
    private val _estateState = mutableStateOf(EstateTextFieldState())
    private val _estateCountry = mutableStateOf(EstateTextFieldState())
    private val _estateNearby = mutableStateOf(EstateTextFieldState())
    private val _estateStatus = mutableStateOf(EstateTextFieldState())

    val estateType: State<EstateTextFieldState> = _estateType
    val estatePrice: State<EstateTextFieldState> = _estatePrice
    val estateSurface: State<EstateTextFieldState> = _estateSurface
    val estateRooms: State<EstateTextFieldState> = _estateRooms
    val estateDescription: State<EstateTextFieldState> = _estateDescription
    val estatePhotos: State<GalleryState> = _estatePhotos
    val estateStreet: State<EstateTextFieldState> = _estateStreet
    val estateExtras: State<EstateTextFieldState> = _estateExtras
    val estateCity: State<EstateTextFieldState> = _estateCity
    val estateState: State<EstateTextFieldState> = _estateState
    val estateCountry: State<EstateTextFieldState> = _estateCountry

    private val _eventFlow = MutableSharedFlow<AddEditEstateEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var state by mutableStateOf(AddEditEstateUi())

    init {
        /*
        viewModelScope.launch {

            savedStateHandle.get<Long>("estate_id")?.let { id ->
                Log.d("PEACH", "ADDEDIT: $id")
                if (id != -1L) {
                    estateRepository.getEstateWithPhotosById(id)
                        .also { estate ->
                            _estateType.value = estateType.value.copy(
                                text = estate.type
                            )
                            _estatePhotos.value =
                                estatePhotos.value
                                    .copy(photos = estate.photos)
                            state = state.copy(
                                photos = estate.photos,
                                type = EstateTextFieldState(estate.type),
                                price = EstateTextFieldState(text = "")
                            )
                        }

                }
            }
        }

         */

        viewModelScope.launch {
            val estate = EstateDto(
                type = "Flat",
                price = 120000f,
                surface = 27f,
                rooms = 1,
                description = "Description",
                address = Address(
                    street = "760 Park Avenue",
                    extras = "Apt 6/7",
                    state = "NY",
                    city = "New York",
                    zip = "10021",
                    country = "UNITED STATES"
                ),
                nearby = "school",
                agent = "Peach"
            )

            val newId = estateRepository.insert(estate)
            val photo = PhotoDto(
                estateId = newId,
                title = "Room",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
            )
            val photo1 = PhotoDto(
                estateId = newId,
                title = "Bedroom",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
            )

            photoRepository.insert(listOf(photo, photo1))
        }
    }

    fun onAction(action: AddEditEstateAction) {
        when (action) {
            is AddEditEstateAction.DeletePhoto -> {
                viewModelScope.launch { photoRepository.delete(action.photo.toPhotoDto()) }
            }
            is AddEditEstateAction.ChangeTitleFocus -> TODO()
            is AddEditEstateAction.EnteredTitle -> {}
            AddEditEstateAction.Save -> {
                viewModelScope.launch {
                    try {
                        val newEstate = EstateDto(
                            type = estateType.value.text,
                            price = estatePrice.value.text.toFloat(),
                            surface = estateSurface.value.text.toFloat(),
                            rooms = estateRooms.value.text.toInt(),
                            description = estateDescription.value.text,
                            address = Address(
                                street = estateCity.value.text,
                                extras = estateExtras.value.text,
                                state = estateState.value.text,
                                city = estateCity.value.text,
                                zip = "null",
                                country = estateCountry.value.text
                            ),
                            nearby = "",
                            isAvailable = true,
                            agent = "",
                        )

                        estateRepository.insert(newEstate)
                    } catch (e: Exception) {
                        _eventFlow.emit(
                            AddEditEstateEvent.ShowSnackBar(
                                message = "The real estate couldn't be saved"
                            )
                        )
                    }
                }
            }
        }
    }
}