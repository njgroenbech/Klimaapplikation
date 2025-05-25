package com.example.klimaaktion.network

import com.example.klimaaktion.model.ChatRequest
import com.example.klimaaktion.model.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface OpenAIService {
    @POST("chat/completions")
    fun getChatCompletion(
        @Header("Authorization") authHeader: String,
        @Body request: ChatRequest
    ): Call<ChatResponse>
}

