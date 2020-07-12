package com.learn.learnandroidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.share_data_fragment.view.*

class ShareDataFragment : Fragment() {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.share_data_fragment, container, false)
        v.send.setOnClickListener{
            val getData=v.enter_text.text.toString()
            val bundle=Bundle()
            bundle.putString("data",getData)
          //  bundle.putBoolean("data",false)
          //  bundle.putDouble("data",20.20)
          //  bundle.putFloat("data",12.2f)
          //  bundle.putInt("data",10)
            fm=childFragmentManager
            val shareDataFragment=ReceiveDataFragment()
            shareDataFragment.arguments=bundle
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,shareDataFragment,"ShareDataFragment")
            ft.commit();
        }

        return v
    }

}