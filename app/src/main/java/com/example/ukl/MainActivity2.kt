package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity2 : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    lateinit var pager: ViewPager
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        pager = findViewById(R.id.pager)
        bottomNav = findViewById(R.id.bottom_navigation)

        val pageAdapter = ViewPageAdapter(initFragments(), supportFragmentManager)
        pager.adapter = pageAdapter

        val email = intent.getStringExtra("String")
        val bundle = Bundle()
        bundle.putString("email", email)
        val fragment = Home()
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction().add(R.id.pager, fragment).commit()

        var data = ArrayList<Item>()
        data.addAll(ItemData().listData)

        bottomNav.setOnItemSelectedListener(this)
        pager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}
            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).setChecked(true)
            }

            override fun onPageScrollStateChanged(state: Int) {}

        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> pager.currentItem = 0
            R.id.wishlist -> pager.currentItem = 1
            R.id.profile -> pager.currentItem = 2
            else -> {}
        }
        return true
    }
    fun initFragments(): ArrayList<Fragment>{
        return arrayListOf(
            Home.newInstance(),
            Favorite.newInstance(),
            Profile.newInstance()
        )
    }
}