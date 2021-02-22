package com.example.project




import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import kotlincodes.com.viewpagerkotlin.fragments.MyFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.btn_image.*
import kotlinx.android.synthetic.main.btn_image.view.*
import java.util.*


class MainActivity : AppCompatActivity() {

    //뒤로가기 연속 클릭 대기 시간
    var mBackWait:Long = 0

    private var list: ArrayList<Int> = arrayListOf(
        R.drawable.ic_baseline_looks_one_24,
        R.drawable.ic_baseline_looks_two_24,
        R.drawable.ic_baseline_looks_3_24,
        R.drawable.ic_baseline_looks_4_24,
        R.drawable.ic_baseline_looks_5_24,
        R.drawable.ic_baseline_looks_6_24
    )
    private var textlist: ArrayList<String> = arrayListOf("취업지원", "창업지원", "주거·금융", "생활·복지", "정책참여", "코로나19")

    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //메인 화면 숨기기
        iv_layout.visibility = View.INVISIBLE;

        MobileAds.initialize(this, getString(R.string.admob_app_id))
        var  mAdView : AdView = findViewById(R.id.adView)
        var cateAdapter = BtnImageAdapter(list, textlist)
        val adRequest: AdRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        var imgs = arrayListOf(R.drawable.cute, R.drawable.cute3, R.drawable.cute4)
        val fragmentAdapter = FragmentAdapter(this, imgs)
        val dpValue = 16
        val d = resources.displayMetrics.density
        val margin = (dpValue * d).toInt()
        val nextIntent = Intent(this, DetailActivity::class.java)

        viewPager.apply {
            clipToPadding = false
            setPadding(margin, 0, margin, 0)
            pageMargin = margin/2
            adapter = fragmentAdapter
            currentItem =  imgs.size * 1000
        }

        rvMain.apply {
            layoutManager  = GridLayoutManager(this@MainActivity, 3)
            adapter = cateAdapter
            cateAdapter.onImageClickAction {
                nextIntent.putExtra("btntext", "$it")
                startActivity(nextIntent)
                //Toast.makeText(this@MainActivity, "개의 품종은 ${it}", Toast.LENGTH_SHORT).show()
            }
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        pageIndicatorView.count = imgs.size



        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) { /*empty*/

            }

            override fun onPageSelected(position: Int) {
                pageIndicatorView.selection = position % imgs.size
            }

            override fun onPageScrollStateChanged(state: Int) { /*empty*/
                Log.i("DraggerState", "$state")
                if(state == 1)
                    viewPager.pauseAutoScroll()
                else
                    viewPager.resumeAutoScroll()
            }
        })



        // 광고가 제대로 로드 되는지 테스트 하기 위한 코드입니다.
        mAdView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                iv_layout.visibility = View.VISIBLE;
            }

            override fun onAdFailedToLoad(errorCode: Int) {

                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {

                // Code to be executed when an ad opens an overlay that

                // covers the screen.
            }

            override fun onAdClicked() {

                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {

                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {

                // Code to be executed when the user is about to return

                // to the app after tapping on an ad.
            }
        }
    }

    // 뒤로가기 버튼 클릭
    override fun onBackPressed() {
        if(System.currentTimeMillis() - mBackWait >=2000 ) {
            mBackWait = System.currentTimeMillis()
            Snackbar.make(viewPager, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Snackbar.LENGTH_LONG).show()
            //Toast.makeText(this, "뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show()
        } else {
            finish() //액티비티 종료
        }
    }

    //메뉴 생성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_action, menu)
        toolbar_title.text = "겨미 어플"
        return true
    }

    //메뉴 클릭 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "검색 클릭", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
