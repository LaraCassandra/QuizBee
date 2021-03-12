package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_land_question_one.*
import kotlinx.android.synthetic.main.activity_sea_question_one.*
import kotlinx.android.synthetic.main.activity_sea_question_one.btn_next
import kotlinx.android.synthetic.main.activity_sea_question_one.rb_sea_answer_four
import kotlinx.android.synthetic.main.activity_sea_question_one.rb_sea_answer_one
import kotlinx.android.synthetic.main.activity_sea_question_one.rb_sea_answer_three
import kotlinx.android.synthetic.main.activity_sea_question_one.rb_sea_answer_two
import kotlinx.android.synthetic.main.activity_sea_question_one.tv_progress
import kotlinx.android.synthetic.main.activity_sea_question_one.tv_seaQuestion
import kotlinx.android.synthetic.main.activity_sky_question_one.*

class SkyQuestionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sky_question_one)

        // GET QUESTION 1
        val skyQuestionsList = Constants.getSkyQuestions()

        //val skyQuestionNumber = 1
        val skyQuestion = skyQuestionsList[0]

        // SET FRONTEND ELEMENTS (DISPLAY THE QUESTION AND ANSWER OPTIONS)
        tv_skyQuestion.text = skyQuestion.question
        rb_sky_answer_one.text = skyQuestion.optionOne
        rb_sky_answer_two.text = skyQuestion.optionTwo
        rb_sky_answer_three.text = skyQuestion.optionThree
        rb_sky_answer_four.text = skyQuestion.correctOption
        tv_progress.text = "1" + "/" + skyQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton

        // CREATE WRONG ANSWERS VARIABLE
        var skyWrongAnswers: Int = 0

        // GET RADIO GROUP SELECTED
        btn_next.setOnClickListener{

            //GET THE CHECKED RADIO BUTTON ID
            var id: Int = rg_skyOptions.checkedRadioButtonId
            if (id!=-1){

                //CAPTURE THE ANSWER
                answer = findViewById(id)

                // CHECK IF WRONG ANSWER WAS SELECTED
                if(answer.text == skyQuestion.optionOne || answer.text == skyQuestion.optionTwo || answer.text == skyQuestion.optionThree){
                    skyWrongAnswers++
                }

                //NAVIGATION
                val intent = Intent(this, SkyQuestionTwoActivity::class.java)
                intent.putExtra(Constants.SKY_WRONG_ANSWERS, skyWrongAnswers)
                startActivity(intent)
                finish()

            } else {

                // VALIDATION (CHECK THAT AN OPTION WAS SELECTED)
                Toast.makeText(applicationContext, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }
    }
}