package com.alijan.basicui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alijan.basicui.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rightQuestionCount = intent.getIntExtra("rightQuestionCount", 0)
        binding.textViewResultCount.text = "Siz 5 sualdan $rightQuestionCount doğru cavab verdiniz!"

        when(rightQuestionCount!!.toInt()){
            0 -> {
                binding.textViewResult.text = "Bərbad bir nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result0)
            }
            1 -> {
                binding.textViewResult.text = "Pis nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result1)
            }
            2 -> {
                binding.textViewResult.text = "Orta bir nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result2)
            }
            3 -> {
                binding.textViewResult.text = "Yaxşı nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result3)
            }
            4 -> {
                binding.textViewResult.text = "Əla bir nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result3)
            }
            5 -> {
                binding.textViewResult.text = "Mükəmməl bir nəticə!"
                binding.imageViewResult.setImageResource(R.drawable.result3)
            }
        }
    }
}