package com.example.asklolalingo.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asklolalingo.R
import com.example.asklolalingo.data.model.Message


class ChatAdapter(private val messages: List<Message>) : RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    companion object {
        private const val VIEW_TYPE_USER = 1 ;
        private const val VIEW_TYPE_LOLA = 2 ;
    }

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].sender == "user") {
            VIEW_TYPE_USER
        } else {
            VIEW_TYPE_LOLA
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.MessageViewHolder {
        val layoutId = if (viewType == VIEW_TYPE_USER) {
            R.layout.item_user_message
        } else {
            R.layout.item_lola_message
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return MessageViewHolder(view) ;
    }

    override fun onBindViewHolder(holder: ChatAdapter.MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.messageTextView.text = message.content

        if (message.sender == "user") {
            holder.messageTextView.setTextColor(Color.BLUE)
        } else {
            holder.messageTextView.setTextColor(Color.GREEN)
        }
    }

    override fun getItemCount(): Int {
        Int = messages.size ;
    }
}