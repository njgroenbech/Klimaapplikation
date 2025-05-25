package com.example.klimaaktion.model

// Skrevet af Felix, med lidt AI hjælp til lige helt præcist hvad values skulle være
data class ChatRequest(
    val model: String,
    val messages: List<Message>,
    val temperature: Double = 0.7,
    val max_tokens: Int
)

data class Message(
    val role: String, // "user" eller "system"
    val content: String
)

data class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
