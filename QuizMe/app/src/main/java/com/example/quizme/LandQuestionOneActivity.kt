package com.example.quizme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_land_question_one.*

class LandQuestionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_question_one)

        //GET QUESTIONS
        val landQuestionsList = Constants.getLandQuestions()

        val landQuestionNumber = 1
        val landQuestion = landQuestionsList[landQuestionNumber - 1]

        tv_landQuestion.text = landQuestion.question
        rb_land_answer_one.text = landQuestion.optionOne
        rb_land_answer_two.text = landQuestion.optionTwo
        rb_land_answer_three.text = landQuestion.correctOption
        rb_land_answer_four.text = landQuestion.optionThree

        tv_progress.text = "$landQuestionNumber" + "/" + landQuestionsList.size

    }
}