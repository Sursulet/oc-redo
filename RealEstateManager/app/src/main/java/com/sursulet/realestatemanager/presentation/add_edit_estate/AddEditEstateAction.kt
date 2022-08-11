package com.sursulet.realestatemanager.presentation.add_edit_estate

import com.sursulet.realestatemanager.domain.model.Photo

sealed class AddEditEstateAction {
    data class EnteredTitle(val value: String): AddEditEstateAction()
    data class ChangeTitleFocus(val value: String): AddEditEstateAction()
    data class DeletePhoto(val photo: Photo): AddEditEstateAction()
    object Save: AddEditEstateAction()
}
