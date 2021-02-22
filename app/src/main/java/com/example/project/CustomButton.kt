package com.example.project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import com.realpacific.clickshrinkeffect.applyClickShrink

@SuppressLint("AppCompatCustomView", "NewApi")
class CustomButton @JvmOverloads constructor (context: Context,
                   attrs: AttributeSet?,
                   defStyleAttr : Int=0) :
    androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {
    init {
        setAnimation()
    }
    private fun setAnimation(){
        this.applyClickShrink()
    }


}