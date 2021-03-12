package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_general_question_one.*
import kotlinx.android.synthetic.main.activity_land_question_one.*
import kotlinx.android.synthetic.main.activity_land_question_one.btn_next
import kotlinx.android.synthetic.main.activity_land_question_one.tv_progress

class GeneralQuestionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_question_one)

        // GET QUESTION 1
        val generalQuestionsList = Constants.getGeneralQuestions()

        val generalQuestion = generalQuestionsList[0]

        // SET FRONTEND ELEMENTS (DISPLAY THE QUESTION AND ANSWER OPTIONS)
        tv_generalQuestion.text = generalQuestion.question
        rb_general_answer_one.text = generalQuestion.correctOption
        rb_general_answer_two.text = generalQuestion.optionTwo
        rb_general_answer_three.text = generalQuestion.optionOne
        rb_general_answer_four.text = generalQuestion.optionThree
        tv_progress.text = "1" + "/" + generalQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton

        // CREATE WRONG ANSWERS VARIABLE
        var generalWrongAnswers: Int = 0

        // GET RADIO GROUP SELECTED
        btn_next.setOnClickListener{

            //GET THE CHECKED RADIO BUTTON ID
            var id: Int = rg_generalOptions.checkedRadioButtonId
            if (id!=-1){

                //CAPTURE THE ANSWER
                answer = findViewById(id)

                // CHECK IF WRONG ANSWER WAS SELECTED
                if(answer.text == generalQuestion.optionOne || answer.text == generalQuestion.optionTwo || answer.text == generalQuestion.optionThree){
                    generalWrongAnswers++
                }

                //NAVIGATION
                val intent = Intent(this, GeneralQuestionTwoActivity::class.java)
                intent.putExtra(Constants.SEA_WRONG_ANSWERS, generalWrongAnswers)
                startActivity(intent)
                finish()

            } else {

                // VALIDATION (CHECK THAT AN OPTION WAS SELECTED)
                Toast.makeText(applicationContext, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }

    }
}