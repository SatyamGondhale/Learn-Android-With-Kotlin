package com.learn.learnandroidwithkotlin

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.dialog_kotlin.view.*
import kotlinx.android.synthetic.main.progress_dialog.view.*

class ProgressDialog : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.progress_dialog, container, false)
        v.normal_progress.setOnClickListener{
            val progressDialog=ProgressDialog(requireContext())
            progressDialog.setTitle("Loading ...")
            progressDialog.setMessage("Press Anywhere on Screen to Dismiss")
            progressDialog.show()
        }
        v.custom_progress.setOnClickListener{
            val progressDialog=ProgressDialog(requireContext(),R.style.CustomProgressColor)
            progressDialog.setTitle("Loading ...")
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
            progressDialog.context
            progressDialog.setMessage("Press Anywhere on Screen to Dismiss")
            progressDialog.show()
        }
        return v
    }

}