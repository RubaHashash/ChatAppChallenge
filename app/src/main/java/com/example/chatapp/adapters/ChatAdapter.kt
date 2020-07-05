package com.example.chatapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.db.ChatRow
import com.example.chatapp.db.UserRow
import kotlinx.android.synthetic.main.chat_row.view.*
import kotlinx.android.synthetic.main.user_row.view.*


class ChatAdapter(val chatlist: List <ChatRow>) : RecyclerView.Adapter<ChatAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.chat_user_image
        val username: TextView = itemView.chat_userName
        val lastMsg: TextView = itemView.latest_message
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.chat_row, parent,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return chatlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = chatlist[position]
        holder.image.setImageResource(currentUser.image!!)
        holder.username.text = currentUser.username!!
        holder.lastMsg.text = currentUser.latestMessage!!

    }

}