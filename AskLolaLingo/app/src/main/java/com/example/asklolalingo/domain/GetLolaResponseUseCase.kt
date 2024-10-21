package com.example.asklolalingo.domain

import com.example.asklolalingo.data.repository.MessageRepository

class GetLolaResponseUseCase(private val messageRepository: MessageRepository) {
    suspend operator fun invoke(inputText: String): String {
        return messageRepository.createLolaTextResponse(inputText)
    }
}