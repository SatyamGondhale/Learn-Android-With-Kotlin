package com.learn.learnandroidwithkotlin

import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.topics_index.*
import kotlinx.android.synthetic.main.topics_index.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [TopicsIndex.newInstance] factory method to
 * create an instance of this fragment.
 */
class TopicsIndex : Fragment() {

    lateinit var fm: FragmentManager
    lateinit var ft: FragmentTransaction

    companion object{
        fun newInstance():TopicsIndex{
            return TopicsIndex()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View =inflater.inflate(R.layout.topics_index, container, false)
        v.welcomeMessage?.setText("Learn Android With Kotlin")
        v.welcomeMessage?.setTextSize(20.0f);
        v.welcomeMessage?.setTextColor(resources.getColor(R.color.colorPrimaryDark))
        v.welcomeMessage?.setTypeface(v.welcomeMessage?.typeface, Typeface.BOLD_ITALIC)
       // v.welcomeMessage?.width=200
        v.welcomeMessage?.isSingleLine=true
        v.welcomeMessage?.ellipsize= TextUtils.TruncateAt.END

        v.edittext_topic?.setOnClickListener{
         //   val fragment=Edittext.newInstance()
            fm=childFragmentManager
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,Edittext.newInstance(),"EdittextFragment")
            ft.commit();
        }
        return v;
    }

}