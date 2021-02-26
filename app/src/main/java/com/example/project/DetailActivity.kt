package com.example.project

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.project.fragment.FragmentDetail
import com.example.project.fragment.FragmentMain
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.details_screen.*
import kotlinx.android.synthetic.main.details_screen.tv_title


class DetailActivity() : AppCompatActivity() {

    private lateinit var tabs: TabLayout
    private lateinit var viewpager: ViewPager
    private val category by lazy { intent.getStringExtra("category_name")  }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details_screen)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        initViews()
        setupViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_action, menu)
        tv_title.text = category
        return true
    }
    private fun setupViewPager() {

        val adapter = FragmentDetail(getSupportFragmentManager())

        //var firstFragmet: FragmentMain = FragmentMain.newInstance("First Fragment")
        //var secondFragmet: FragmentMain = FragmentMain.newInstance("Second Fragment")
        //var thirdFragmet: FragmentMain = FragmentMain.newInstance("Third Fragment")

        var names: ArrayList<String> = ArrayList(getPolicyData(category!!))

        tabs_main.tabCount = names.count()

        for (i in 0 until names.count()){
            adapter.addFragment(FragmentMain.newInstance("First Fragment$i"),names[i].toString())
        }
        viewpager!!.adapter = adapter

        tabs!!.setupWithViewPager(viewpager)

       // com.example.project.adapter.addFragment(secondFragmet, "TWO")
      //  com.example.project.adapter.addFragment(thirdFragmet,"THREE")

//        vp_detailPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//            override fun onPageScrolled(
//                    position: Int,
//                    positionOffset: Float,
//                    positionOffsetPixels: Int
//            ) { /*empty*/
//
//            }
//
//            override fun onPageSelected(position: Int) {
//                Log.i("DraggerState2", "$position")
//              //  pageIndicatorView.selection = position % imgs.size
//            }
//
//            override fun onPageScrollStateChanged(state: Int) { /*empty*/
//                Log.i("DraggerState", "$state")
////                if (state == 1)
////                    vp_banner.pauseAutoScroll()
////                else
////                    vp_banner.resumeAutoScroll()
//
//            }
//
//        })

    }

    private fun getPolicyData(policyType: String): List<String> {
        var names: List<String> = emptyList()
        when (policyType) {

            "취업지원" -> {
                names = listOf("교육훈련·체험·인턴", "중소(중견)기업 취업지원", "전문분야 취업지원", "해외진출")
            }
            "창업지원" -> {
                names = listOf("R&D 지원", "경영 지원", "자본금 지원")
            }
            "주거·금융" -> {
                names = listOf("생활비지원 및 금융 혜택", "주거지원", "학자금 지원")
            }
            "생활·복지" -> {
                names = listOf("건강", "문화")
            }
            "정책참여" -> {
                names = listOf("정책제안", "권리보호", "지역발전")
            }
            "코로나19" -> {
                names = listOf("기본소득지원", "저소득층지원", "재난피해지원", "소득및일자리보전", "기타 인센티브", "심리지원")
            }
        }
        return names;
    }


    private fun initViews() {
        tabs = findViewById(R.id.tabs_main)
        viewpager = findViewById(R.id.vp_detailPage)
    }
}
