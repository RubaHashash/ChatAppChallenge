package com.example.chatapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.db.UserRow
import com.example.chatapp.ui.ConversationActivity
import kotlinx.android.synthetic.main.user_row.view.*

class MyAdapter(val userlist: List <UserRow>) :RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.user_image
        val username: TextView = itemView.userName
        val ItemLayout = itemView.findViewById<LinearLayout>(R.id.linearLayout_users)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_row, parent,false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentUser = userlist[position]
        holder.image.setImageResource(currentUser.image!!)
        holder.username.text = currentUser.username!!

        val userHolder = holder as MyViewHolder
        userHolder.ItemLayout.setOnClickListener {
            Navigation.findNavController(userHolder.itemView).navigate(R.id.action_mainFragment_to_conversationActivity)
        }
    }

}