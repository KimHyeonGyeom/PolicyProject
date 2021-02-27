package com.example.project.fragment

import Listener.RecyclerTouchListener
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.adapter.DetailCategoryAdapter
import kotlinx.android.synthetic.main.fragment_cate.*


class FragmentMain : Fragment() {

    lateinit var mContext: Context
    companion object {
         fun newInstance(message: String): FragmentMain {

            val f = FragmentMain()
            val bdl = Bundle(1)

            bdl.putString(EXTRA_MESSAGE, message)
            f.arguments = bdl

            return f

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    private lateinit var message: String
    private var mLayoutManager: RecyclerView.LayoutManager? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var list: java.util.ArrayList<Int> = arrayListOf(
            R.drawable.category_jobsupport,
            R.drawable.categort_dwelling_finance,
            R.drawable.category_startsupport,
            R.drawable.category_life_welfare,
            R.drawable.category_policyparticipation,
            R.drawable.category_covid19
    )
    private var lis2: java.util.ArrayList<Int> = arrayListOf(
            R.drawable.category_jobsupport,
            R.drawable.categort_dwelling_finance,
    )
    private  var textlist: java.util.ArrayList<String> =
            arrayListOf("취업지원", "주거·금융", "창업지원", "생활·복지", "정책참여", "코로나19")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_cate, container, false);
        message = arguments?.getString(EXTRA_MESSAGE).toString()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        tv_text!!.text = message


        when (message) {
            "생활비지원 및 금융 혜택" -> {
                var cateAdapter = DetailCategoryAdapter(list)
                rv_detail_category.apply {
                    layoutManager = GridLayoutManager(mContext, 1)
                    adapter = cateAdapter
                }

                // row click listener
                rv_detail_category.addOnItemTouchListener(RecyclerTouchListener(mContext, R.id.ll_policy_layout, object : RecyclerTouchListener.ClickListener {

                    override fun onClick(view: View?, position: Int) {
                        Toast.makeText(mContext, " is selected!$position", Toast.LENGTH_SHORT).show()

                        //view?.background =
                        //view?.setBackground(ContextCompat.getDrawable(mContext, R.attr.selectableItemBackgroundBorderless));
                        //val outValue = TypedValue()
                        //context!!.theme.resolveAttribute(android.R.attr.selectableItemBackground, this,., true)
                        //view?.setBackgroundResource(outValue.resourceId)

                    }

                    override fun onLongClick(view: View?, position: Int) {

                    }
                }))
            }
            "주거지원" -> {
                var cateAdapter = DetailCategoryAdapter(lis2)
                rv_detail_category.apply {
                    layoutManager = GridLayoutManager(mContext, 1)
                    adapter = cateAdapter
                }
            }
//            "창업지원" -> {
//                names = listOf("R&D 지원", "경영 지원", "자본금 지원")
//            }
//            "주거·금융" -> {
//                names = listOf("생활비지원 및 금융 혜택", "주거지원", "학자금 지원")
//            }
//            "생활·복지" -> {
//                names = listOf("건강", "문화")
//            }
//            "정책참여" -> {
//                names = listOf("정책제안", "권리보호", "지역발전")
//            }
//            "코로나19" -> {
//                names = listOf("기본소득지원", "저소득층지원", "재난피해지원", "소득및일자리보전", "기타 인센티브", "심리지원")
//            }
        }


    }
}