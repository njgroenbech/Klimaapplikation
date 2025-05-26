package com.example.klimaaktion.model

import androidx.compose.ui.graphics.Color

// Nedenstående kode er lavet af Elias
// Details og quiz er tilføjet af Felix

data class Task(
    val id: Int, // ID bliver brugt til Viewmodel funktionen remove
    val title: String,
    val points: Int,
    val backgroundColor: Color,
    val fact: String,
    val details: String,
    val quiz: List<QuizQuestion>,
    val trophy: Trophy? = null,
    val isCompleted: Boolean = false
)