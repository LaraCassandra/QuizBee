package com.example.quizme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_land_flag_results.*
import kotlinx.android.synthetic.main.activity_land_results.*
import kotlinx.android.synthetic.main.activity_land_results.tv_score
import kotlinx.android.synthetic.main.activity_land_results.tv_username
import kotlinx.android.synthetic.main.activity_land_results.btn_back as btn_back1

class GeneralResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_results)

        // GET INTENT
        val username = intent.getStringExtra(Constants.USER_NAME)
        val wrongAnswers = intent.getIntExtra(Constants.GEN_WRONG_ANSWERS, 0)

        // GET SCORE
        val score = 3 - wrongAnswers

        // SET VIEW BASED ON SCORE
        if (wrongAnswers >= 2){
            setContentView(R.layout.activity_general_flag_results)
            tv_username.text = "${username}!"
            tv_score.text = "${score}/3"
        } else {
            setContentView(R.layout.activity_general_results)
            tv_username.text = "${username}!"
            tv_score.text = "${score}/3"
        }

        // BACK BUTTON LISTENER
        btn_back.setOnClickListener{
            // NAVIGATE BACK TO CATEGORIES PAGE
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
            finish()
        }

        // SHARED PREFERENCES
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
            putString(Constants.USER_NAME, username)
            putInt(Constants.GEN_WRONG_ANSWERS, wrongAnswers)
            apply()
        }

    }
}