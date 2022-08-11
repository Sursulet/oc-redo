package com.sursulet.realestatemanager.presentation.list

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color

data class EstateItemUi(
    val id: Long,
    val photo: Bitmap,
    val type: String,
    val price: Float,
    val city: String,
    val isSelected: Color = Color.White
)
