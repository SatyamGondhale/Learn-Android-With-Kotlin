package com.learn.learnandroidwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent_data.*

class IntentDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_data)
        val receivedData=intent.getStringExtra("data")
        receive_data.text=receivedData
    }
}