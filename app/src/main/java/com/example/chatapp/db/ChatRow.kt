package com.example.chatapp.db

import androidx.room.PrimaryKey

data class ChatRow(
    val username:String,
    val image:Int,
    val latestMessage:String) {

}