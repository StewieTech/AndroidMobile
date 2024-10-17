package com.example.asklolalingo.data.model

data class Choice (
    val index: Int,
    val message: Message,
    val finish_reson: String?
)
