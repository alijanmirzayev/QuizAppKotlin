package com.alijan.basicui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.alijan.basicui.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var questionId = 1
        var rightQuestionCount = 0
        val questionsArrayList = arrayListOf<Question>()

        val questionOne = Question(
            "Türkiyə liqasında ən çox çempion olan komanda hansıdır?",
            "Trabzonspor",
            "Beşiktaş",
            "Galatasaray",
            "Fenerbahçe",
            "Fenerbahçe",
            1
        )
        val questionTwo = Question(
            "Türkiyə liqasında penaltısız ən çox qol atan oyunçu kimdir?",
            "Icardi",
            "Dzeko",
            "Aboubakar",
            "Rey Manej",
            "Dzeko",
            2
        )
        val questionThree = Question(
            "Aşağıdakı komandalardan hansı FETO teror örgütü ilə əlaqəsi sübut olmuş komandadır?",
            "Trabzonspor",
            "Beşiktaş",
            "Galatasaray",
            "Fenerbahçe",
            "Galatasaray",
            3
        )
        val questionFour = Question(
            "Aşağıdakı komandalardan hansı ilə Fenerbahçe arasında 6 cavabsız qol fərqi olmuşdur?",
            "Trabzonspor",
            "Beşiktaş",
            "Galatasaray",
            "Başakşehir",
            "Galatasaray",
            4
        )
        val questionFive = Question(
            "Aşağıdakı oyunçulardan hansı ilə PSG və İnterdə oynamış lakin o komandalardan qovulmuşdur?",
            "Icardi",
            "Dzeko",
            "Aboubakar",
            "Rey Manej",
            "Icardi",
            5
        )
        questionsArrayList.add(questionOne)
        questionsArrayList.add(questionTwo)
        questionsArrayList.add(questionThree)
        questionsArrayList.add(questionFour)
        questionsArrayList.add(questionFive)

        binding.textViewQuestion.text = questionOne.question
        binding.radioButton.text = questionOne.answerOne
        binding.radioButton2.text = questionOne.answerTwo
        binding.radioButton3.text = questionOne.answerThree
        binding.radioButton4.text = questionOne.answerFour

        binding.buttonSubmit.setOnClickListener {

            val oldFindedQuestion = questionsArrayList.find { it.id == questionId }

            val selectedRadioButtonId = binding.radioGroup.checkedRadioButtonId
            val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
            val selectedOption = selectedRadioButton.text.toString()

            if (oldFindedQuestion != null && oldFindedQuestion.answerRight == selectedOption) {
                rightQuestionCount ++
            }

            if (questionId == 5) {
                val intent = Intent(this@QuizActivity, ResultActivity::class.java)
                intent.putExtra("rightQuestionCount", rightQuestionCount)
                startActivity(intent)
                finish()
            }

            questionId ++
            val findedQuestion = questionsArrayList.find { it.id == questionId }

            if (findedQuestion != null) {
                binding.textViewQuestion.text = findedQuestion.question
                binding.radioButton.text = findedQuestion.answerOne
                binding.radioButton2.text = findedQuestion.answerTwo
                binding.radioButton3.text = findedQuestion.answerThree
                binding.radioButton4.text = findedQuestion.answerFour
            }

        }
    }
}