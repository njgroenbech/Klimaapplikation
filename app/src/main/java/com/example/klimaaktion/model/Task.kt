package com.example.klimaaktion.model

import androidx.compose.ui.graphics.Color

// Nedenstående kode er lavet af Elias

data class Task(
    val id: Int, // ID bliver brugt til Viewmodel funktionen remove
    val title: String,
    val points: Int,
    val backgroundColor: Color,
    val fact: String,
    val details: String,
    val quiz: List<QuizQuestion>
)