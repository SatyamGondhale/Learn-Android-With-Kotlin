package com.learn.learnandroidwithkotlin

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.runtime_permission.view.*

class RuntimePermission : Fragment() {

    val REQUESTCODE:Int=101
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.runtime_permission, container, false)
        v.storage_permission.setOnClickListener{
            val isPermission=isPermission()
            if(isPermission){
                Toast.makeText(requireContext(),"Permission Granted already",Toast.LENGTH_SHORT).show()
            }else{
           // ActivityCompat.requestPermissions(activity as AppCompatActivity,arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),REQUESTCODE)
             // Use above code in case of Activity else for Fragment use below code otherwise onRequestPermission will not work
                requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),REQUESTCODE)
            }
        }

        return v
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        when(requestCode){
           REQUESTCODE->{
               if(grantResults.isNotEmpty() &&  grantResults[0]==PackageManager.PERMISSION_GRANTED){
                   Toast.makeText(requireContext(),"Permission Granted Now",Toast.LENGTH_SHORT).show()
               }else{
                   Toast.makeText(requireContext(),"Permission Denied Now",Toast.LENGTH_SHORT).show()
               }
           }
       }
    }
    fun isPermission():Boolean {
        var permissionStatus:Boolean=false
        val permission=ContextCompat.checkSelfPermission(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(permission!=PackageManager.PERMISSION_GRANTED){
            permissionStatus=false
        }else{
            permissionStatus=true
        }
        return permissionStatus
    }

}