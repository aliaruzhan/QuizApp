package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import com.example.quiz.Constants.CORRECT_ANSWERS
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {


    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null

    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0

    private var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tvTrue.setOnClickListener {
            selectedView(tvTrue, 1)
        }

        tvFalse.setOnClickListener {
            selectedView(tvFalse, 2)
        }
        showanswer.setOnClickListener {
            val myQuestion = mQuestionsList?.get(mCurrentPosition - 1)

            if(count<3){
            val newintent =
                Intent(this@QuestionActivity, AnswerActivity::class.java)
            newintent.putExtra(CORRECT_ANSWERS, myQuestion!!.correctAnswer)
            startActivity(newintent)
        }
            else{
                showanswer.text = "No more"
            }
            count++
        }

        next.setOnClickListener {
            if (mSelectedOptionPosition == 0) {
                mCurrentPosition++

                when {

                    mCurrentPosition <= mQuestionsList!!.size -> {
                        setQuestion()
                    }
                    else -> {
                        val intent =
                                Intent(this@QuestionActivity, ResultActivity::class.java)
                        intent.putExtra(CORRECT_ANSWERS, mCorrectAnswers)
                        startActivity(intent)
                        finish()
                        // END
                    }
                }
            } else {
                val question = mQuestionsList?.get(mCurrentPosition - 1)

                if (question!!.correctAnswer == mSelectedOptionPosition) {
                    mCorrectAnswers++
                }

                if (mCurrentPosition == mQuestionsList!!.size) {
                    next.text = "FINISH"
                } else {
                    next.text = "Next"
                }

                mSelectedOptionPosition = 0
            }
        }
    }


    private fun setQuestion() {

        val question =
                mQuestionsList!!.get(mCurrentPosition - 1) // Getting the question from the list with the help of current position.

        defaultView(android.R.color.darker_gray)

        if (mCurrentPosition == mQuestionsList!!.size) {
            next.text = "FINISH"
        }

        tvQuestion.text = question.question
        tvImage.setImageResource(question.image)
        tvTrue.text = question.optionOne
        tvFalse.text = question.optionTwo
    }

    private fun selectedView(tv: TextView, selectedOptionNum: Int) {
        defaultView(android.R.color.darker_gray)
        mSelectedOptionPosition = selectedOptionNum
    }

    private fun defaultView(drawableView: Int) {

        val options = ArrayList<TextView>()
        options.add(0, tvTrue)
        options.add(1, tvFalse)

        for (option in options) {
            ViewCompat.setBackgroundTintList(option, ContextCompat.getColorStateList(this, drawableView))
        }
    }
}