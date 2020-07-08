package com.learn.learnandroidwithkotlin

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.custom_diaog.view.*
import kotlinx.android.synthetic.main.dialog_kotlin.*
import kotlinx.android.synthetic.main.dialog_kotlin.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [DialogKotlin.newInstance] factory method to
 * create an instance of this fragment.
 */
class DialogKotlin : Fragment() {

    companion object{
        fun newInstance():DialogKotlin{
            return DialogKotlin()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.dialog_kotlin, container, false)
        v.normal_dialog.setOnClickListener{
           /* AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Message");
            builder.setMessage("Are you sure to delete item's of "+entries.get(position).getBusinessName());
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    }
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            builder.show();*/
            val alertDialogBuilder=AlertDialog.Builder(requireActivity())
            alertDialogBuilder.setTitle("Dialog Title")
            alertDialogBuilder.setMessage("Dialog Message...")
            // perform positive action
            alertDialogBuilder.setPositiveButton("Yes"){
                dialogInterface, which ->
                Toast.makeText(requireActivity(),"clicked yes",Toast.LENGTH_LONG).show()
            }
            //performing cancel action
            alertDialogBuilder.setNeutralButton("Cancel"){dialogInterface , which ->
                Toast.makeText(requireActivity(),"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            }
            //performing negative action
            alertDialogBuilder.setNegativeButton("No"){dialogInterface, which ->
                Toast.makeText(requireActivity(),"clicked No",Toast.LENGTH_LONG).show()
            }
            val alertDialog:AlertDialog=alertDialogBuilder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }


        v.custom_dialog.setOnClickListener{
            val customDialogView=layoutInflater.inflate(R.layout.custom_diaog,container,false)
            val alertDialogBuilder=AlertDialog.Builder(requireActivity())
                .setView(customDialogView)
                .setTitle("Custom Dialog Kotlin")
            val alertDialog:AlertDialog=alertDialogBuilder.create()
            alertDialog.setCancelable(false)
            customDialogView.custom_dialog_action.setOnClickListener{
                Toast.makeText(requireActivity(),"Custom Dialog close",Toast.LENGTH_LONG).show()
                alertDialog.dismiss()
            }
            alertDialog.show()
        }
        return v
    }

}