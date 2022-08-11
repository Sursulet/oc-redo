package com.sursulet.realestatemanager.presentation.add_edit_estate

sealed class AddEditEstateEvent {
    data class ShowSnackBar(val message: String): AddEditEstateEvent()
    object Save: AddEditEstateEvent()
}