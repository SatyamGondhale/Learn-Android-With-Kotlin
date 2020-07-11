package com.learn.learnandroidwithkotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.share_data_activity.view.*

class ShareDataActivity : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.share_data_activity, container, false)
        v.send_data.setOnClickListener{
            val getData=v.type_data.text.toString()
            val currentAct=activity as AppCompatActivity
            val intent= Intent(activity as AppCompatActivity,IntentDataActivity::class.java)
            intent.putExtra("data",getData)
            startActivity(intent)
            currentAct.finish()
        }
        return v
    }

}