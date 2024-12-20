package com.example.asklolalingo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
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
import com.example.asklolalingo.adapters.ChatAdapter
import com.example.asklolalingo.data.model.Message

class ChatFragment : Fragment() {

    private lateinit var viewModel: ChatViewModel  ;
    private lateinit var recyclerView: RecyclerView ;
    private lateinit var chatAdapter: ChatAdapter ;
    private val messages = mutableListOf<Message>()

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
        chatAdapter = ChatAdapter(messages) ;
        recyclerView.adapter = chatAdapter ;


        btnSend.setOnClickListener {
            val userMessage = inputEditText.text.toString()
            if (userMessage.isNotEmpty()) {
                inputEditText.text.clear()

                val message = Message(userMessage, sender = "user") ;
                messages.add(message) ;
                chatAdapter.notifyItemInserted(messages.size - 1) ;

                viewModel.getLolaResponse(userMessage) ;
            }
        }

        viewModel.lolaResponse.observe(viewLifecycleOwner) {
            response ->
            val lolaMessage = Message(response, sender = "lola")
            messages.add(lolaMessage)
            chatAdapter.notifyItemInserted(messages.size - 1)
            recyclerView.scrollToPosition(messages.size -1 )
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            error -> Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
        }



    }
}