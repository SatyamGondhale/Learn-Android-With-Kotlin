package com.learn.learnandroidwithkotlin

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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
        v.toast_topic.setOnClickListener{
            fm=childFragmentManager
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,ToastMessage.newInstance(),"ToastFragment")
            ft.commit();
        }
        v.dialog_topic.setOnClickListener{
            fm=childFragmentManager
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,DialogKotlin.newInstance(),"DialogFragment")
            ft.commit();
        }
        v.listview_topic.setOnClickListener{
            fm=childFragmentManager
            val listviewFragment=ListView()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,listviewFragment,"ListViewFragment")
            ft.commit();
        }
        v.datatransfer_activity.setOnClickListener{
            fm=childFragmentManager
            val shareDataActivity=ShareDataActivity()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,shareDataActivity,"ShareDataFragment")
            ft.commit();
        }
        v.datatransfer_fragment.setOnClickListener{
            fm=childFragmentManager
            val shareDataFragment=ShareDataFragment()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,shareDataFragment,"ShareDataFragment")
            ft.commit();
        }
        v.radiogroup_topic.setOnClickListener{
            fm=childFragmentManager
            val radioGroupFragment=RadioGroup()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,radioGroupFragment,"RadioGroupFragment")
            ft.commit();
        }
        v.checkbox_topic.setOnClickListener{
            fm=childFragmentManager
            val checkboxFragment=Checkbox()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,checkboxFragment,"CheckboxFragment")
            ft.commit();
        }
        v.recyclerview_topic.setOnClickListener{
            fm=childFragmentManager
            val recyclerviewFragment=Recyclerview()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,recyclerviewFragment,"RecyclerviewFragment")
            ft.commit();
        }
        v.navdrawer_topic.setOnClickListener{
            val currentAct=activity as AppCompatActivity
            val intent= Intent(activity as AppCompatActivity,NavDrawer::class.java)
            startActivity(intent)
            currentAct.finish()
        }
        v.options_context_topic.setOnClickListener{
            val currentAct=activity as AppCompatActivity
            val intent= Intent(activity as AppCompatActivity,OptionsContextMenu::class.java)
            startActivity(intent)
            currentAct.finish()
        }
        v.progressdialog_topic.setOnClickListener{
            fm=childFragmentManager
            val progressDialogFragment=ProgressDialog()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,progressDialogFragment,"RecyclerviewFragment")
            ft.commit();
        }
        v.notifications_topic.setOnClickListener{
            fm=childFragmentManager
            val notificationFragment=Notifications()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,notificationFragment,"NotificationFragment")
            ft.commit();
        }
        v.runtime_permission_topic.setOnClickListener{
            fm=childFragmentManager
            val permissionsFragment=RuntimePermission()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,permissionsFragment,"PermissionFragment")
            ft.commit();
        }
        v.tabview_topic.setOnClickListener{
            fm=childFragmentManager
            val tabviewFragment=TabView()
            ft=requireActivity().supportFragmentManager.beginTransaction()
            ft.replace(R.id.app_frame,tabviewFragment,"TabViewFragment")
            ft.commit();
        }
        return v;
    }

}