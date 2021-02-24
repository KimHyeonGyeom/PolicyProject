package com.example.project.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import kotlinx.android.synthetic.main.btn_image.view.*
import java.util.*

class BtnImageAdapter(private val  imageList: ArrayList<Int>, private val textList: ArrayList<String>) : RecyclerView.Adapter<BtnImageAdapter.MyViewHolder>() {
    private val startTime: Date = Calendar.getInstance().time

    private lateinit var context: Context
    lateinit var action: (Any) -> Unit
    //변수
    //var aaa: String? = null
    //상수
    //val aa = ""
    //나중에 무조건 값이 들어올때
    //lateinit var aaa1: String
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.btn_image, parent, false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(imageList[position], textList[position])

    }


    fun onImageClickAction(itemClick: (Any) -> Unit){
        action = itemClick
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(i: Int, textlist: String) {
            itemView.tvItemSquare.apply{
                setOnClickListener { action(textlist)}
                Glide.with(itemView.context).load(context.getDrawable(i)).into(this)
            }
            itemView.btnText.text = textlist

        }
    }

}