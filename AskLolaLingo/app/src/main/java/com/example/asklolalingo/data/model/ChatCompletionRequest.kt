package com.example.asklolalingo.data.model

class ChatCompletionRequest (

    val model: String,
    val messages: List<Message>,
    val max_tokens: Int?,
    val temperature: Double?
)
