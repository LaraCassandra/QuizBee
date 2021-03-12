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

        // CATEGORY 1
        btn_cat1.setOnClickListener {
            val intent = Intent(this, LandQuestionOneActivity::class.java)
            startActivity(intent)
        }

        // CATEGORY 2
        btn_cat2.setOnClickListener{
            val intent = Intent(this, SeaQuestionOneActivity::class.java)
            startActivity(intent)
        }

        // CATEGORY 3
        btn_cat3.setOnClickListener{
            val intent = Intent(this, SkyQuestionOneActivity::class.java)
            startActivity(intent)
        }

        // CATEGORY 4
        btn_cat4.setOnClickListener{
            val intent = Intent(this, GeneralQuestionOneActivity::class.java)
            startActivity(intent)
        }

    }
}