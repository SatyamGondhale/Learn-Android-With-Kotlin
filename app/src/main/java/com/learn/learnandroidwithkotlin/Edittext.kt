package com.learn.learnandroidwithkotlin

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.edittext.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Edittext.newInstance] factory method to
 * create an instance of this fragment.
 */
class Edittext : Fragment() {
    // TODO: Rename and change types of parameters

    companion object{
        fun newInstance():Edittext{
            return Edittext()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout.edittext, container, false)
        v.edittext.setHint("Enter Text to Display")
        v.edittext.setHintTextColor(resources.getColor(R.color.colorPrimaryDark))
        v.edittext.setTextSize(20.0f)

        v.shwoText.setOnClickListener{
            val text=v.edittext.text
            v.showEdittexttext.setText(text)
            v.showEdittexttext.setTextSize(25.0f)
        }
        return v
    }
}