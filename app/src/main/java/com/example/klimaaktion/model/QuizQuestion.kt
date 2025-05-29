package com.example.klimaaktion.model

// Skrevet af Felix, godkendt af chatGPT
data class QuizQuestion(
    val question: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)
