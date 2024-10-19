package com.example.asklolalingo.domain.repositories

import com.example.asklolalingo.data.LolaPersonalityLevels
import com.example.asklolalingo.data.model.ChatCompletionRequest
import com.example.asklolalingo.data.model.Message
import com.example.asklolalingo.domain.remote.OpenAIService

class MessageRepository(private val openAIService: OpenAIService) {

    private var userLevel: Int = 2 ;

    suspend fun createLolaTextResponse(inputText: String): String {
        val contentAnswer = LolaPersonalityLevels.getPersonalityByLevel(userLevel)

        val messages = listOf(
            Message(role = "system", content = contentAnswer),
            Message(role = "user", content = inputText)
        )

        val request = ChatCompletionRequest(
            model = "gpt-3.5-turbo",
            messages = messages,
            max_tokens = 40,
            temperature = 0.0
        )

        val response = openAIService.createChatCompletion(request)

        return response.choices.firstOrNull()?.message?.content ?: "No response from Lola.";
    }
}