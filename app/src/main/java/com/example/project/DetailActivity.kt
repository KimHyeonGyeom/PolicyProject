package com.example.project

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlincodes.com.viewpagerkotlin.fragments.MyFragment
import kotlinx.android.synthetic.main.details_screen.*


class DetailActivity() : AppCompatActivity() {

    private lateinit var tabs: TabLayout
    private lateinit var viewpager: ViewPager

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
        toolbar_title.text = intent.getStringExtra("btntext")
        return true
    }
    private fun setupViewPager() {

        val adapter = MyPagerAdapter(getSupportFragmentManager())

        var firstFragmet: MyFragment = MyFragment.newInstance("First Fragment")
        var secondFragmet: MyFragment = MyFragment.newInstance("Second Fragment")
        var thirdFragmet: MyFragment = MyFragment.newInstance("Third Fragment")


        adapter.addFragment(firstFragmet,"ONE")
       // adapter.addFragment(secondFragmet, "TWO")
      //  adapter.addFragment(thirdFragmet,"THREE")

        viewpager!!.adapter = adapter

         tabs!!.setupWithViewPager(viewpager)

    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs_main)
        viewpager = findViewById(R.id.iv_cover)
    }
}
