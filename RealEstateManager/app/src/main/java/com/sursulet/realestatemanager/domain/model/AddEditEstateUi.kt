package com.sursulet.realestatemanager.domain.model

import com.sursulet.realestatemanager.presentation.add_edit_estate.EstateTextFieldState
import java.time.LocalDate

data class AddEditEstateUi(
    val created: String = "",//LocalDate.now().toString(),
    val photos: List<Photo> = emptyList(),
    val type: EstateTextFieldState = EstateTextFieldState(),
    val price: EstateTextFieldState = EstateTextFieldState() /*,
    val description: EstateTextFieldState,
    val surface: EstateTextFieldState,
    val rooms: EstateTextFieldState,
    val bathrooms: EstateTextFieldState,
    val bedrooms: EstateTextFieldState,

    val street: EstateTextFieldState,
    val extras: EstateTextFieldState,
    val city: EstateTextFieldState,
    val state: EstateTextFieldState,
    val zip: EstateTextFieldState,
    val country: EstateTextFieldState,

    val saleTimeStamp: EstateTextFieldState,
    val nearby: EstateTextFieldState,
    val agent: EstateTextFieldState*/
)
