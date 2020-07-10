package com.learn.learnandroidwithkotlin

import Adapters.ListViewAdapter
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main._list_view.view.*
import model.ListViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ListView.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View = inflater.inflate(R.layout._list_view, container, false)
        val languages= arrayOf<String>("C","C++","Java","JavaScript","Ruby")
        val imageId = arrayOf<Int>(
            R.drawable.c_lang,R.drawable.cplus_image,R.drawable.java_language,R.drawable.javascript_image,R.drawable.ruby_language
        )
        val context=context as Context
        val adapter=ArrayAdapter(requireActivity(),android.R.layout.simple_list_item_1,languages)
        v.normal_listview.setOnClickListener{
            v.display_list.adapter=adapter
            v.display_list.onItemClickListener=AdapterView.OnItemClickListener{
                adapterView, view, i, l ->
                val selectedItem=adapterView.getItemAtPosition(i) as String
                val itemIdAtPos = adapterView.getItemIdAtPosition(i)
                Toast.makeText(requireActivity(),"click item $selectedItem its position $itemIdAtPos",Toast.LENGTH_SHORT).show()
            }
        }

        v.custom_listview.setOnClickListener{
            var list = mutableListOf<ListViewModel>()
            list.add(ListViewModel("C",R.drawable.c_lang))
            list.add(ListViewModel("C++",R.drawable.cplus_image))
            list.add(ListViewModel("Java",R.drawable.java_language))
            val myCustomAdapter=ListViewAdapter(requireActivity(),list)
            v.display_list.adapter=myCustomAdapter
            v.display_list.setOnItemClickListener{
                    parent,view,position,id->
                val getItem=list.get(position) as ListViewModel
                Toast.makeText(requireActivity(),"click item "+getItem.lang,Toast.LENGTH_SHORT).show()

            }

        }

        return v
    }
}