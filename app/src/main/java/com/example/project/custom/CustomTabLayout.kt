package com.example.project.custom

import android.content.Context
import android.util.AttributeSet
import com.example.project.adapter.BtnImageAdapter
import com.google.android.material.tabs.TabLayout
import java.lang.reflect.Field

class CustomTabLayout : TabLayout {

    constructor(context: Context?) : super(context!!) {

    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context!!, attrs
    ) {

    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!, attrs, defStyleAttr
    ) {

    }

    fun setTabCount(tabCount : Int){
        initTabMinWidth(tabCount)
    }

    private fun initTabMinWidth(tabCount: Int) {
        val wh: IntArray =  Utils.getScreenSize(context)
        val tabMinWidth = wh[WIDTH_INDEX] / tabCount
        val field: Field
        try {
            field = TabLayout::class.java.getDeclaredField(SCROLLABLE_TAB_MIN_WIDTH)
            field.isAccessible = true
            field.set(this, tabMinWidth)
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }

    companion object {
        private const val WIDTH_INDEX = 0
        private const val SCROLLABLE_TAB_MIN_WIDTH = "scrollableTabMinWidth"
    }
}