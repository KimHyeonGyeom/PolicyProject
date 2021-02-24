package com.example.project.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.btn_image.view.*
import java.util.*
import kotlin.collections.ArrayList

class FragmentDetail(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    private val mFragmentList: ArrayList<Fragment> = ArrayList()
    private var mFragmentTitleList= ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
      //  mFragmentTitleList = title
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList.get(position)
    }
 }
