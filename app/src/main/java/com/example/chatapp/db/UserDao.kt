package com.example.chatapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Insert
    fun insert(user:UserRow)

    @Insert
    fun insertAll(users: List<UserRow>)

    @Query("SELECT * FROM userrow")
    fun getAllUsers():List<UserRow>


}