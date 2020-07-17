package com.learn.learnandroidwithkotlin

import Adapters.RecyclerviewAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recyclerview.view.*
import model.RecyclerviewModel

class Recyclerview : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=inflater.inflate(R.layout.recyclerview, container, false)
        v.languageList.setHasFixedSize(true)
        v.languageList.layoutManager=LinearLayoutManager(requireActivity())
        val dataList=ArrayList<RecyclerviewModel>()
        dataList.add(RecyclerviewModel("C language"))
        dataList.add(RecyclerviewModel("C++ language"))
        dataList.add(RecyclerviewModel("Java language"))
        dataList.add(RecyclerviewModel("Dart language"))
        dataList.add(RecyclerviewModel(".Net language"))
        val adapter=RecyclerviewAdapter(dataList = dataList,
            clickListener = { data:RecyclerviewModel->languageCardClicked(data)})
        v.languageList.adapter=adapter
        return v
    }

    private fun languageCardClicked(lang:RecyclerviewModel){
        Toast.makeText(requireContext(),lang.languages,Toast.LENGTH_SHORT).show()
    }

}