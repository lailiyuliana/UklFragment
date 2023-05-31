package com.example.ukl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        view_pager.adapter = ViewPageAdapter2(initFragments(), this, supportFragmentManager)
    }
    fun initFragments(): ArrayList<Fragment>{
        return arrayListOf(
            Form.newInstance(),
            Tampil.newInstance()
        )
    }
}