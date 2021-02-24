package com.example.project.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.project.R


class BannerAdapter(context: Context, imageList: ArrayList<Int>) :
    PagerAdapter()  {
    private val mContext: Context = context
    private val imageList: ArrayList<Int> = imageList

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.fragment_image, null)
        val imageView: ImageView = view.findViewById(R.id.riv_benner)
        imageView.setImageResource(imageList[position%imageList.size])
//        Glide.with(mContext).load(imageList[position%imageList.size]).into(imageView)
        container.addView(view)

        return view
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o as View
    }


}