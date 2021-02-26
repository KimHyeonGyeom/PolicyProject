package com.example.project.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.project.R
import kotlinx.android.synthetic.main.fragment_cate.*


class FragmentMain : Fragment() {

    companion object {
         fun newInstance(message: String): FragmentMain {

            val f = FragmentMain()
            val bdl = Bundle(1)

            bdl.putString(EXTRA_MESSAGE, message)
            f.arguments = bdl

            return f

        }
    }

    private lateinit var message: String
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_cate, container, false);

        message = requireArguments().getString(EXTRA_MESSAGE)!!
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_text!!.text = message //이미 데이터 값을 넣었다.

    }
}