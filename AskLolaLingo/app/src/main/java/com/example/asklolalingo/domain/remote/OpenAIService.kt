package com.example.asklolalingo.domain.remote
import retrofit2.http.Body
import retrofit2.http.Headers ;
import retrofit2.http.POST ;


interface OpenAIService {
    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    suspend fun createChatCompletion(
        @Body request: ChatCompletionRequest
    ) : ChatCompletionResponse
}