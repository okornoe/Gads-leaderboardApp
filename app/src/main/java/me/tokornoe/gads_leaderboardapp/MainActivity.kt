package me.tokornoe.gads_leaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_main)


        tabLayout =findViewById(R.id.tab_layout)
        viewPager = findViewById(R.id.pager)

        tabLayout.addTab(tabLayout.newTab().setText("Learning Hours Leader board"))
        tabLayout.addTab(tabLayout.newTab().setText("IQ leader board"))
    }
}