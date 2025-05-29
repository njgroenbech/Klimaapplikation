package com.example.klimaaktion.model

// Skrevet af ChatGPT

data class TaskRaw(
    val id: Int,
    val title: String,
    val points: Int,
    val backgroundColor: String,
    val fact: String,
    val details: String,
    val quiz: List<QuizQuestion>
)