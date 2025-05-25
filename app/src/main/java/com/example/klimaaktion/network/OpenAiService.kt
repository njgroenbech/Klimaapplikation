package com.example.klimaaktion.network

import com.example.klimaaktion.model.ChatRequest
import com.example.klimaaktion.model.ChatResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAIService {
    @Headers(
        "Content-Type: application/json",
        "Authorization: Bearer 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" // ← Brug din rigtige API-nøgle her (midlertidigt)
    )
    @POST("chat/completions")
    fun getChatCompletion(
        @Body request: ChatRequest
    ): Call<ChatResponse>
}
