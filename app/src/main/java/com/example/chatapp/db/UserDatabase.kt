package com.example.chatapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [UserRow::class],
    version = 1
)

abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao

}