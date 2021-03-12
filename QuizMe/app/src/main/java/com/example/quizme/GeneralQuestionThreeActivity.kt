package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_general_question_one.*
import kotlinx.android.synthetic.main.activity_general_question_one.btn_next
import kotlinx.android.synthetic.main.activity_general_question_one.tv_progress
import kotlinx.android.synthetic.main.activity_sky_question_one.*

class GeneralQuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_general_question_three)
        var generalWrongAnswers = intent.getIntExtra(Constants.GEN_WRONG_ANSWERS, 0)

        // GET QUESTION
        val generalQuestionsList = Constants.getGeneralQuestions()

        val generalQuestion = generalQuestionsList[2]

        // SET FRONTEND ELEMENTS (DISPLAY THE QUESTION AND ANSWER OPTIONS)
        tv_generalQuestion.text = generalQuestion.question
        rb_general_answer_one.text = generalQuestion.optionOne
        rb_general_answer_two.text = generalQuestion.optionTwo
        rb_general_answer_three.text = generalQuestion.correctOption
        rb_general_answer_four.text = generalQuestion.optionThree
        tv_progress.text = "3" + "/" + generalQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton


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
                val intent = Intent(this, SkyQuestionThreeActivity::class.java)
                intent.putExtra(Constants.GEN_WRONG_ANSWERS, generalWrongAnswers)
                startActivity(intent)
                finish()

            } else {

                // VALIDATION (CHECK THAT AN OPTION WAS SELECTED)
                Toast.makeText(applicationContext, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }

    }
}