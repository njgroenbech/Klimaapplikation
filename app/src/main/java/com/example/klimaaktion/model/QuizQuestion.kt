package com.example.klimaaktion.model

// Skrevet af Felix
data class QuizQuestion(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)
