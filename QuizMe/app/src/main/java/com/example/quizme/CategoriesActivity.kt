package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_categories.*

class CategoriesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)

        // EXTRACT THE STRING FROM THE INTENT
        val userName = intent.getStringArrayExtra(EXTRA_MESSAGE)

        // SET TEXT IN CATEGORY LAYOUT
        tv_name.text = "Hi " + userName + "!"

        // CATEGORY 1
        btn_cat1.setOnClickListener {
            val intent = Intent(this, LandQuestionOneActivity::class.java)
            startActivity(intent)
        }

    }
}