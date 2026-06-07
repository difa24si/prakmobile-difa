package com.example.dipaflower.pertemuan_10

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TenthTabsAdapter(activity: AppCompatActivity) :
    FragmentStateAdapter(activity) {

    // Jumlah tab
    override fun getItemCount(): Int = 3

    // Fragment tiap tab
    override fun createFragment(position: Int): Fragment {

        return when (position) {

            0 -> TabAFragment()

            1 -> TabBFragment()

            2 -> TabCFragment()

            else -> throw IllegalArgumentException("Tab tidak ditemukan")
        }
    }
}