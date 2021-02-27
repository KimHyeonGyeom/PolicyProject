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
import kotlinx.android.synthetic.main.policy_list.view.*
import java.util.*
import kotlin.collections.ArrayList


class DetailCategoryAdapter(private val imageList: ArrayList<Int>)  : RecyclerView.Adapter<DetailCategoryAdapter.MyViewHolder>() ,View.OnClickListener{
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

        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.policy_list, parent, false))
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(imageList[position])
    }


    fun onImageClickAction(itemClick: (Any) -> Unit){
        action = itemClick
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("UseCompatLoadingForDrawables")
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        fun bind(i: Int) {
            itemView.iv_policy_list.apply{

                Glide.with(itemView.context).load(context.getDrawable(i)).into(this)
            }
           // itemView.btnText.text = textlist

        }
    }

    override fun onClick(v: View?) {

        when(v?.id)
        {
            R.id.vp_detailPage -> {

            }
        }
    }
}