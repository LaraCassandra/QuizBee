package com.example.quizme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_land_flag_results.*
import kotlinx.android.synthetic.main.activity_land_results.*
import kotlinx.android.synthetic.main.activity_land_flag_results.btn_back as btn_back1

class LandResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // GET INTENT
        val username = intent.getStringExtra(Constants.USER_NAME)
        val landWrongAnswers = intent.getIntExtra(Constants.LAND_WRONG_ANSWERS, 0)

        // GET SCORE
        val landScore = 3 - landWrongAnswers

        // SET VIEW BASED ON SCORE
        if (landWrongAnswers >= 2){
            setContentView(R.layout.activity_land_flag_results)
            tv_landFlagScore.text = "${landScore}/3"
        } else {
            setContentView(R.layout.activity_land_results)
            tv_landScore.text = "${landScore}/3"
        }

        // SHARED PREFERENCES
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply{
            putString(Constants.USER_NAME, username)
            putInt(Constants.LAND_WRONG_ANSWERS, landWrongAnswers)
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