package com.example.asklolalingo.domain

class GetLolaResponseUseCase(private val messageRepository: MessageRepository) {
    suspend operator fun invoke(inputText: String): String {
        return messageRepository.createLolaTextResponse(inputText)
    }
}