package com.example.asklolalingo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.asklolalingo.BuildConfig
import com.example.asklolalingo.data.repository.MessageRepository
import com.example.asklolalingo.domain.GetLolaResponseUseCase
import com.example.asklolalingo.domain.remote.NetworkModule
import com.example.asklolalingo.viewmodels.ChatViewModel
import com.example.asklolalingo.viewmodels.ChatViewModelFactory
import com.example.asklolalingo.R ;

class ChatFragment : Fragment() {

    private lateinit var viewModel: ChatViewModel
    private lateinit var recyclerView: RecyclerView ;
//    private lateinit var chatAda

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val apiKey = BuildConfig.OPENAI_API_KEY ;
        val openAIService = NetworkModule.provideOpenAIService(apiKey) ;
        val messageRepository = MessageRepository(openAIService) ;
        val getLolaResponseUseCase = GetLolaResponseUseCase(messageRepository) ;

        val viewModelFactory = ChatViewModelFactory(getLolaResponseUseCase) ;
        viewModel = ViewModelProvider(this, viewModelFactory).get(ChatViewModel::class.java) ;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_ask_lola_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) ;

        val btnSend = view.findViewById<ImageButton>(R.id.btnSend) ;
        val inputEditText = view.findViewById<EditText>(R.id.inputEditText) ;
        recyclerView = view.findViewById(R.id.recyclerView) ;

        recyclerView.layoutManager = LinearLayoutManager(requireContext()) ;


        btnSend.setOnClickListener {
            val userMessage = inputEditText.text.toString()
            if (userMessage.isNotEmpty()) {
                inputEditText.text.clear()
            }
        }
    }
}