package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sky_flag_results.*
import kotlinx.android.synthetic.main.activity_sky_flag_results.btn_back
import kotlinx.android.synthetic.main.activity_sky_flag_results.tv_username
import kotlinx.android.synthetic.main.activity_sky_results.*

class SkyResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // GET INTENT
        val username = intent.getStringExtra(Constants.USER_NAME)
        val wrongAnswers = intent.getIntExtra(Constants.SKY_WRONG_ANSWERS, 0)

        // GET SCORE
        val score = 3 - wrongAnswers

        // SET VIEW BASED ON SCORE
        if (wrongAnswers >= 2){
            setContentView(R.layout.activity_sky_flag_results)
            tv_username.text = "${username}!"
            tv_skyFlagScore.text = "${score}/3"
        } else {
            setContentView(R.layout.activity_sky_results)
            tv_username.text = "${username}!"
            tv_skyScore.text = "${score}/3"
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