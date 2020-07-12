package com.learn.learnandroidwithkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.radio_group.view.*

class RadioGroup : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.radio_group, container, false)
        v.radio_group.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener{
            radioGroup, checkedId ->  val radioId:RadioButton=v.findViewById(checkedId)
            Toast.makeText(requireActivity(),"${radioId.text}",Toast.LENGTH_SHORT).show()
        })

      /*  Get the checked radio button id from radio group
        var id: Int = v.radio_group.checkedRadioButtonId
      */

        /* Get the clicked radio button instance
        val radio: RadioButton = findViewById(v.radio_group.checkedRadioButtonId)*/
        return v
    }

}