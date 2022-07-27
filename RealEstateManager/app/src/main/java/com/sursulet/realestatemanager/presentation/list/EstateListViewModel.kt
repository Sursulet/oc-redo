package com.sursulet.realestatemanager.presentation.list

import android.graphics.Bitmap
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sursulet.realestatemanager.data.local.Address
import com.sursulet.realestatemanager.data.local.Estate
import com.sursulet.realestatemanager.data.local.Photo
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
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
            val photo = Photo(
                estateId = 1,
                title = "Room",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
            )
            val photo1 = Photo(
                estateId = 1,
                title = "Bedroom",
                image = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888)
            )
            val estate = Estate(
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
                    postCode = "10021",
                    country = "UNITED STATES"
                ),
                nearby = "school",
                agent = "Peach"
            )

            //val newId = repository.insert(estate)
            //Log.d("PEACH", "getEstates: $newId")

            //photoRepository.insert(listOf(photo,photo1))

            val test = repository.getEstatesWithPhotos().first() //.getEstates().first()
            Log.d("PEACH", "getEstates: $test")

            val testy = repository.getEstateItems().first()
            Log.d("PEACH", "getEstateItems: $testy")


            repository.getEstateItems()
                .collect { result ->
                    state = state.copy(estates = result)
                }


        }
    }

    private fun onEstateClicked() {}
}