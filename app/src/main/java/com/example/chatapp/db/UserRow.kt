package com.example.chatapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserRow(
    val username:String,
    val image:Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}