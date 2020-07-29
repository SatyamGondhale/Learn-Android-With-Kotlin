package com.learn.learnandroidwithkotlin

import Adapters.TabLayoutAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.tab_view.*
import kotlinx.android.synthetic.main.tab_view.view.*
import kotlinx.android.synthetic.main.tab_view.view.tabLayout

class TabView : Fragment() {

    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.tab_view, container, false)
        tabLayout = v.findViewById<TabLayout>(R.id.tabLayout)
        viewPager = v.findViewById<ViewPager>(R.id.viewPager)
        tabLayout!!.addTab(tabLayout!!.newTab().setText("TabOne"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("TabTwo"))
        v.tabLayout!!.tabGravity=TabLayout.GRAVITY_FILL
        val adapter=TabLayoutAdapter(requireContext(),requireActivity().supportFragmentManager,tabLayout!!.tabCount)
        v.viewPager.adapter=adapter
        v.viewPager!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(v.tabLayout))
        v.tabLayout!!.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
                v.viewPager.currentItem= p0?.position!!
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {

            }

        })
        return v
    }

}