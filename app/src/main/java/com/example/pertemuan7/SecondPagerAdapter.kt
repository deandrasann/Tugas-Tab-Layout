package com.example.pertemuan7

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SecondPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        when(position){
            0 -> fragment = HomeFragment()
            1 -> fragment = MaterialFragment()
            2 -> fragment = QuizFragment()
        }
        return fragment as Fragment
    }

}