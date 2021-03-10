package com.example.quizme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.TextView

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        // REFERENCE TO UI
        val tv_name = findViewById<TextView>(R.id.tv_name)

        // EXTRACT THE STRING FROM THE INTENT
        val userName = intent.getStringArrayExtra(EXTRA_MESSAGE)

        // SET TEXT IN CATEGORY LAYOUT
        tv_name.text = "Hi " + userName + "!"

    }
}