package com.example.project.custom

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.widget.ImageView
import com.realpacific.clickshrinkeffect.applyClickShrink

@SuppressLint("AppCompatCustomView", "NewApi")
class CustomButton @JvmOverloads constructor (context: Context,
                   attrs: AttributeSet?,
                   defStyleAttr : Int=0) :
    ImageView(context, attrs, defStyleAttr) {
    init {
        setAnimation()
    }
    private fun setAnimation(){
        this.applyClickShrink()
    }


}