package com.learn.learnandroidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.receive_data_fragment.*
import kotlinx.android.synthetic.main.receive_data_fragment.view.*

class ReceiveDataFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.receive_data_fragment, container, false)
        val getValue=arguments?.getString("data","")
        // val getValue=arguments?.getFloat("data",false)
        // val getValue=arguments?.getDouble("data")
        // val getValue=arguments?.getFloat("data")
        // val getValue=arguments?.getInt("data")
        v.received_data.text="Data Received "+getValue
        return v
    }

}