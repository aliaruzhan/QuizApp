package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_answer.*

class AnswerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        toolbar_answer_activity.setNavigationOnClickListener{
            onBackPressed()
        }

        Toast.makeText(this@AnswerActivity, "Cheating is Bad!",Toast.LENGTH_SHORT).show()
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        showAnswer(correctAnswers)
    }

    private fun showAnswer(correctAnswers: Int){
        if(correctAnswers == 1) {
            answer_text_view.text = "True"
        } else{
            answer_text_view.text = "False"
        }

        answer_text_view.visibility = View.VISIBLE
    }
    
}