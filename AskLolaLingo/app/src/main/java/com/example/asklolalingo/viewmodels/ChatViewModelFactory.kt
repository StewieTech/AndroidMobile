package com.example.asklolalingo.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.asklolalingo.domain.GetLolaResponseUseCase


class ChatViewModelFactory {
    private val getLolaResponseUseCase: GetLolaResponseUseCase ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ChatViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ChatViewModel(getLolaResponseUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class");
        }
    }
}