package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_land_question_one.*
import kotlinx.android.synthetic.main.activity_sea_question_one.*
import kotlinx.android.synthetic.main.activity_sea_question_one.btn_next
import kotlinx.android.synthetic.main.activity_sea_question_one.tv_progress

class SeaQuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sea_question_three)

        var seaWrongAnswers = intent.getIntExtra(Constants.SEA_WRONG_ANSWERS, 0)

        // GET QUESTION 2
        val seaQuestionsList = Constants.getSeaQuestions()

        //val seaQuestionNumber = 1
        val seaQuestion = seaQuestionsList[2]

        // SET FRONTEND ELEMENTS (DISPLAY THE QUESTION AND ANSWER OPTIONS)
        tv_seaQuestion.text = seaQuestion.question
        rb_sea_answer_one.text = seaQuestion.optionOne
        rb_sea_answer_two.text = seaQuestion.optionTwo
        rb_sea_answer_three.text = seaQuestion.correctOption
        rb_sea_answer_four.text = seaQuestion.optionThree
        tv_progress.text = "3" + "/" + seaQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton

        // GET RADIO GROUP SELECTED
        btn_next.setOnClickListener{

            //GET THE CHECKED RADIO BUTTON ID
            var id: Int = rg_seaOptions.checkedRadioButtonId
            if (id!=-1){

                //CAPTURE THE ANSWER
                answer = findViewById(id)

                // CHECK IF WRONG ANSWER WAS SELECTED
                if(answer.text == seaQuestion.optionOne || answer.text == seaQuestion.optionTwo || answer.text == seaQuestion.optionThree){
                    seaWrongAnswers++
                }

                //NAVIGATION
                val intent = Intent(this, SeaQuestionThreeActivity::class.java)
                intent.putExtra(Constants.SEA_WRONG_ANSWERS, seaWrongAnswers)
                startActivity(intent)
                finish()

            } else {

                // VALIDATION (CHECK THAT AN OPTION WAS SELECTED)
                Toast.makeText(applicationContext, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }
    }
}