package com.learn.learnandroidwithkotlin

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.toast_message.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [ToastMessage.newInstance] factory method to
 * create an instance of this fragment.
 */
class ToastMessage : Fragment() {


    companion object{
        fun newInstance():ToastMessage{
            return ToastMessage()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.toast_message, container, false)
        v.show_toast.setOnClickListener{
            Toast.makeText(requireActivity(),"Showing Toast",Toast.LENGTH_SHORT).show()
        }

        v.show_custom_toast.setOnClickListener{
            val layout=layoutInflater.inflate(R.layout.custom_toast,container,false)
            val context=activity as Context  // get activity context on Fragment
            val myToast=Toast(context)       // initialize Toast
            myToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)    // Set gravity for Toast
            myToast.view = layout            //setting the view of custom toast layout
            myToast.show()
        }
        return v
    }
}