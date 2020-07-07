package com.learn.learnandroidwithkotlin

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Array.newInstance

class MainActivity : AppCompatActivity() {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fm=supportFragmentManager
        ft=fm.beginTransaction()
        ft.replace(R.id.app_frame,TopicsIndex.newInstance(),"IndexFragment").commit();
    }
}