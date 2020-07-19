package com.learn.learnandroidwithkotlin

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.notifications.view.*

class Notifications : Fragment() {

    lateinit var notificationManager : NotificationManager
    lateinit var notificationChannel : NotificationChannel
    lateinit var builder : Notification.Builder

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v:View=inflater.inflate(R.layout.notifications, container, false)
        v.create_notification.setOnClickListener{
            val channelId = "com.learn.learnandroidwithkotlin_kotlinandroid"
            val channelname= "learn_android_kotlin"
            if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
                val context=activity as Context
                val resultIntent = Intent(activity as AppCompatActivity,MainActivity::class.java)
                val pendingIntent = PendingIntent.getActivity(
                    requireContext(),
                    0,
                    resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationChannel=NotificationChannel(channelId,channelname,NotificationManagerCompat.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.enableVibration(true)
                notificationManager.createNotificationChannel(notificationChannel)
                builder=Notification.Builder(requireContext(),channelId)
                    .setContentText("Hello I am a test Notificaton")
                    .setSmallIcon(R.drawable.notification_img)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                notificationManager.notify(123,builder.build())
            }else{
                val context=activity as Context
                notificationManager=context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val resultIntent = Intent(activity as AppCompatActivity,MainActivity::class.java)
                val pendingIntent = PendingIntent.getActivity(
                    requireContext(),
                    0,
                    resultIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                builder=Notification.Builder(requireContext())
                    .setContentText("Hello I am a test Notificaton")
                    .setSmallIcon(R.drawable.notification_img)
                    .setDefaults(Notification.DEFAULT_SOUND)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true)
                notificationManager.notify(123,builder.build())
            }
        }
        return v
    }

}