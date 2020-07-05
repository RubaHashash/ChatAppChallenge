package com.example.chatapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.room.Room
import com.example.chatapp.adapters.MyAdapter
import com.example.chatapp.adapters.PageAdapter
import com.example.chatapp.R
import com.example.chatapp.adapters.ChatAdapter
import com.example.chatapp.db.ChatRow
import com.example.chatapp.db.UserDatabase
import com.example.chatapp.db.UserRow
import kotlinx.android.synthetic.main.fragment_chats.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_users.*

class MainActivity : AppCompatActivity() {
    var myAdapter: MyAdapter?= null
    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = PageAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        var db = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "User Database").build()

        Thread{
            val myUserList = UsersList(200)
            db.getUserDao().insertAll(myUserList)

            myAdapter = MyAdapter(myUserList)
            usersList.adapter = myAdapter
        }.start()

    }
    private fun UsersList(size:Int): List<UserRow>{
        val list = ArrayList<UserRow>()

        for(i in 1 until size+1){
            val drawable = when(i % 3){
                0-> R.drawable.user1
                1->R.drawable.user2
                else->R.drawable.user3
            }

            val user = UserRow("Friend $i",drawable)
            list += user
        }
        return list
    }



}
