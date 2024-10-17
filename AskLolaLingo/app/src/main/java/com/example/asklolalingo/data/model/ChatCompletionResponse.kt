package com.example.asklolalingo.data.model

data class ChatCompletionResponse (
    val id: String,
    val `object` : String,
    val created: Long,
    val choices: List<Choice>,
    val usage: Usage?

)
