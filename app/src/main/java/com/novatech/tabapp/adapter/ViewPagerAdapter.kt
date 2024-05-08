package com.novatech.tabapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.novatech.tabapp.fragments.BooksFragment
import com.novatech.tabapp.fragments.GamesFragment
import com.novatech.tabapp.fragments.MoviesFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {


    override fun getItemCount(): Int {
        // 3 is the number of tabs
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->{
                return BooksFragment()
            }
            1->{
                return GamesFragment()
            }


        }
        return MoviesFragment()
    }
}