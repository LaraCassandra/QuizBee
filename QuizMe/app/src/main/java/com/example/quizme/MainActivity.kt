package com.example.quizme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // MAKE APP FULLSCREEN
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // REFERENCE TO UI
        val btn_start = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<TextView>(R.id.et_name)

        // START BUTTON FUNCTION
        btn_start.setOnClickListener {

            // NAME VALIDATION
            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, CategoriesActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, et_name.text.toString())
                }
                startActivity(intent)
                finish()
            }

        }

    }
}