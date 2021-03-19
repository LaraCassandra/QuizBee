package com.example.quizme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sea_flag_results.*
import kotlinx.android.synthetic.main.activity_sea_results.*
import kotlinx.android.synthetic.main.activity_sea_flag_results.btn_back as btn_back1

class SeaResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // GET INTENT
        val username = intent.getStringExtra(Constants.USER_NAME)
        val seaWrongAnswers = intent.getIntExtra(Constants.SEA_WRONG_ANSWERS, 0)

        // GET SCORE
        val seaScore = 3 - seaWrongAnswers

        // SET VIEW BASED ON SCORE
        if (seaWrongAnswers >= 2){
            setContentView(R.layout.activity_sea_flag_results)
            tv_seaFlagScore.text = "${seaScore}/3"
        } else {
            setContentView(R.layout.activity_sea_results)
            tv_seaScore.text = "${seaScore}/3"
        }


        // SHARED PREFERENCES
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
            putString(Constants.USER_NAME, username)
            putInt(Constants.SEA_WRONG_ANSWERS, seaWrongAnswers)
            apply()
        }


        // BACK BUTTON LISTENER
        btn_back.setOnClickListener{
            // NAVIGATE BACK TO CATEGORIES PAGE
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}