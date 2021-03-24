package com.example.quizme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_score_board.*

class ScoreBoard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_board)

        //SHARED PREFERENCES
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        //GET VALUES
        val last_user_name = sharedPref.getString(Constants.USER_NAME, "No User")
        val generalWrongAnswers = sharedPref.getInt(Constants.GEN_WRONG_ANSWERS, 0)
        val landWrongAnswers = sharedPref.getInt(Constants.LAND_WRONG_ANSWERS, 0)
        val seaWrongAnswers = sharedPref.getInt(Constants.SEA_WRONG_ANSWERS, 0)
        val skyWrongAnswers = sharedPref.getInt(Constants.SKY_WRONG_ANSWERS, 0)

        //GET SCORE
        val genScore = 3 - generalWrongAnswers
        val landScore = 3 - landWrongAnswers
        val seaScore = 3 - seaWrongAnswers
        val skyScore = 3 - skyWrongAnswers

        //SET SCORE
        tv_username.text = "${last_user_name}"
        tv_genScoreboard.text = "${genScore}/3"
        tv_landScoreboard.text = "${landScore}/3"
        tv_seaScoreboard.text = "${seaScore}/3"
        tv_skyScoreboard.text = "${skyScore}/3"

        //CLOSE SCOREBOARD
        btn_exit.setOnClickListener{
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}