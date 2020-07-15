package com.learn.learnandroidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.checkbox.view.*
import kotlin.jvm.java

class Checkbox : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.checkbox, container, false)
        v.java.setOnCheckedChangeListener{
            compoundButton, b ->
            if(b){
                Toast.makeText(requireActivity(),v.java.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        v.kotlin.setOnCheckedChangeListener{
                compoundButton, b ->
            if(b){
                Toast.makeText(requireActivity(),v.kotlin.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        v.javascript.setOnCheckedChangeListener{
                compoundButton, b ->
            if(b){
                Toast.makeText(requireActivity(),v.javascript.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        v.react.setOnCheckedChangeListener{
                compoundButton, b ->
            if(b){
                Toast.makeText(requireActivity(),v.react.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }
        v.angular.setOnCheckedChangeListener{
                compoundButton, b ->
            if(b){
                Toast.makeText(requireActivity(),v.angular.text.toString(),Toast.LENGTH_SHORT).show()
            }
        }

        return v
    }

}