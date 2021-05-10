package com.example.quiz

object Constants{
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val q1 = Question(1,
            "Tony Stark is the richest Marvel character",
            R.drawable.tonystark,
            "True",
            "False",
            2)

        val q2 = Question(2,
            "The first infinity stone to appear was the Space Stone",
            R.drawable.spacestone,
            "True",
            "False",
            1)

        val q3 = Question(3,
            "The most expensive marvel movie is The Age of Ultron",
            R.drawable.ageofultron,
            "True",
            "False",
            1)

        val q4 = Question(4,
            "Groot has never said anything else apart from the phrase:“I am Groot”",
            R.drawable.groot,
            "True",
            "False",
            2)

        val q5 = Question(5,
            "Nick Fury lost his eye, because it was scratched by a cat",
            R.drawable.nickfury,
            "True",
            "False",
            1)

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)

        return questionList
    }
}