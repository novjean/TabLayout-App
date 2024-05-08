package com.novatech.tabapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.novatech.tabapp.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    val tabsArray = arrayOf("Books", "Games", "Movies")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        var myAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = myAdapter

        // this is needed to connect to the tabs
        TabLayoutMediator(tabLayout, viewPager) {
            tab, position -> tab.text = tabsArray[position]
        }.attach()
    }
}