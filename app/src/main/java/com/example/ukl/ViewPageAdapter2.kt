package com.example.ukl

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPageAdapter2(val fragment: ArrayList<Fragment>,private val mContext: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return fragment.size
    }

    override fun getItem(position: Int): Fragment {
        return fragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(TAB_TITLES[position])
    }

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tabs_1, R.string.tabs_2)
    }
}