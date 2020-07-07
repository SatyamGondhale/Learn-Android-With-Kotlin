package com.learn.learnandroidwithkotlin

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initial Commit
        welcomeMessage.setText("Learn Android With Kotlin")
        welcomeMessage.setTextSize(20.0f);
        welcomeMessage.setTextColor(resources.getColor(R.color.colorPrimaryDark))
        welcomeMessage.setTypeface(welcomeMessage.typeface,Typeface.BOLD_ITALIC)
        welcomeMessage.width=200
        welcomeMessage.isSingleLine=true
        welcomeMessage.ellipsize=TextUtils.TruncateAt.END
    }
}