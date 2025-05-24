package com.example.klimaaktion.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Trophy(
    @DrawableRes val iconRes: Int,
    val title: String,
    val backgroundColor: Color,
    val isCompleted: Boolean
)