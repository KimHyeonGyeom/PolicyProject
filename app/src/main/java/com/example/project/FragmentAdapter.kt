package com.example.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter


class FragmentAdapter(context: Context, imageList: ArrayList<Int>) :
    PagerAdapter()  {
    private val mContext: Context = context
    private val imageList: ArrayList<Int> = imageList

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.fragment_image, null)
        val imageView: ImageView = view.findViewById(R.id.imageView)
        imageView.setImageResource(imageList[position%imageList.size])
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