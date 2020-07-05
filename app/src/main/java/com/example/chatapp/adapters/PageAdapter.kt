package com.example.chatapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.chatapp.fragments.Chats
import com.example.chatapp.fragments.Users

class PageAdapter(fm:FragmentManager):FragmentPagerAdapter(fm){
    /**
     * Return the Fragment associated with a specified position.
     */
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return Chats()
            1-> return Users()
            else -> return Chats()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> return "Chats"
            1-> return "Friends"
        }
        return super.getPageTitle(position)
    }
    /**
     * Return the number of views available.
     */
    override fun getCount(): Int {
        return 2
    }

}