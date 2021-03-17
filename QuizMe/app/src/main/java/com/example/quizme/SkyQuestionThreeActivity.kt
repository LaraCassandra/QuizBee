package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_land_question_one.*
import kotlinx.android.synthetic.main.activity_sky_question_one.*
import kotlinx.android.synthetic.main.activity_sky_question_one.btn_next
import kotlinx.android.synthetic.main.activity_sky_question_one.tv_progress

class SkyQuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sky_question_three)

        var skyWrongAnswers = intent.getIntExtra(Constants.SKY_WRONG_ANSWERS, 0)

        // GET QUESTION
        val skyQuestionsList = Constants.getSkyQuestions()

        //val skyQuestionNumber = 3
        val skyQuestion = skyQuestionsList[2]

        // SET FRONTEND ELEMENTS (DISPLAY THE QUESTION AND ANSWER OPTIONS)
        tv_skyQuestion.text = skyQuestion.question
        rb_sky_answer_one.text = skyQuestion.optionOne
        rb_sky_answer_two.text = skyQuestion.correctOption
        rb_sky_answer_three.text = skyQuestion.optionTwo
        rb_sky_answer_four.text = skyQuestion.optionThree
        tv_progress.text = "3" + "/" + skyQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton


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
                val intent = Intent(this, SkyResultsActivity::class.java)
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