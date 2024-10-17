package com.example.asklolalingo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel(private val getLolaResponseUseCase: GetLolaResponseUseCase) : ViewModel {
    private val _response = MutableLiveData<String>() ;
    val response: LiveData<String> get() = _response ;

    fun getLolaResponse(inputText: String) {
        viewModelScope.launch {
            try {
                val result = getLolaResponseUseCase(inputText) ;
                _response.value = result ;
            } catch (e : Exception) {
                _response.value = "Error: ${e.message}"
            }
        }
    }
}