package com.example.klimaaktion.model

import androidx.compose.ui.graphics.Color

data class Task(
    val id: Int,
    val title: String,
    val points: Int,
    val backgroundColor: Color,
    val fact: String
)