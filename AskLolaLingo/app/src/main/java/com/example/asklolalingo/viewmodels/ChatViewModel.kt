package com.example.asklolalingo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.asklolalingo.domain.GetLolaResponseUseCase
import kotlinx.coroutines.launch

class ChatViewModel(private val getLolaResponseUseCase: GetLolaResponseUseCase) : ViewModel() {
    private val _lolaResponse = MutableLiveData<String>() ;
    val lolaResponse: LiveData<String> get() = _lolaResponse ;

    private val _errorMessage = MutableLiveData<String>() ;
    val errorMessage: LiveData<String> get() = _errorMessage  ;

    fun getLolaResponse(inputText: String) {
        viewModelScope.launch {
            try {
                val result = getLolaResponseUseCase(inputText) ;
                _lolaResponse.value = result ;
            } catch (e : Exception) {
                _errorMessage.value = "Error: ${e.message}"
            }
        }
    }
}