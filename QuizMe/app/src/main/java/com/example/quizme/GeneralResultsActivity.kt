package com.example.quizme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_general_flag_results.*
import kotlinx.android.synthetic.main.activity_general_flag_results.btn_back
import kotlinx.android.synthetic.main.activity_general_results.*

class GeneralResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // GET INTENT
        val username = intent.getStringExtra(Constants.USER_NAME)
        val generalWrongAnswers = intent.getIntExtra(Constants.GEN_WRONG_ANSWERS, 0)

        // GET SCORE
        val generalScore = 3 - generalWrongAnswers

        // SET VIEW BASED ON SCORE
        if (generalWrongAnswers >= 2){
            setContentView(R.layout.activity_general_flag_results)
            tv_genFlagScore.text = "${generalScore}/3"
        } else {
            setContentView(R.layout.activity_general_results)
            tv_genScore.text = "${generalScore}/3"
        }


        // SHARED PREFERENCES
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
            putString(Constants.USER_NAME, username)
            putInt(Constants.GEN_WRONG_ANSWERS, generalWrongAnswers)
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