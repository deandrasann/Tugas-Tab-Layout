package com.example.pertemuan7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SecondPagerAdapter(activity: AppCompatActivity, private val loginArgs: Bundle? = null) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment ? = null

        when(position) {
            0 -> fragment = LoginFragment().apply {
                arguments = loginArgs
            }
            1 -> fragment = RegisterFragment()
        }
        return fragment as Fragment
    }
}