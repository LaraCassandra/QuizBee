package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_land_question_one.*

class LandQuestionThreeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_question_three)

        var landWrongAnswers = intent.getIntExtra(Constants.LAND_WRONG_ANSWERS, 0)

        // GET QUESTION
        val landQuestionsList = Constants.getLandQuestions()

        val landQuestionNumber = 3
        val landQuestion = landQuestionsList[landQuestionNumber + 1]

        // SET FRONTEND ELEMENTS
        tv_landQuestion.text = landQuestion.question
        rb_land_answer_one.text = landQuestion.optionOne
        rb_land_answer_two.text = landQuestion.optionTwo
        rb_land_answer_three.text = landQuestion.correctOption
        rb_land_answer_four.text = landQuestion.optionThree
        tv_progress.text = "$landQuestionNumber" + "/" + landQuestionsList.size

        // CHECK RADIO BUTTON SELECTION
        var answer: RadioButton

        // GET RADIO GROUP SELECTED
        btn_next.setOnClickListener{

            //GET THE CHECKED RADIO BUTTON ID
            var id: Int = rg_landOptions.checkedRadioButtonId
            if (id!=-1){

                //CAPTURE THE ANSWER
                answer = findViewById(id)

                // CHECK IF WRONG ANSWER WAS SELECTED
                if(answer.text == landQuestion.optionOne || answer.text == landQuestion.optionTwo || answer.text == landQuestion.optionThree){
                    landWrongAnswers++
                }

                //NAVIGATION
                val intent = Intent(this, LandQuestionTwoActivity::class.java)
                intent.putExtra(Constants.LAND_WRONG_ANSWERS, landWrongAnswers)
                startActivity(intent)
                finish()

            } else {

                // VALIDATION (CHECK THAT AN OPTION WAS SELECTED)
                Toast.makeText(applicationContext, "Please select an answer", Toast.LENGTH_LONG).show()
            }
        }
    }
}