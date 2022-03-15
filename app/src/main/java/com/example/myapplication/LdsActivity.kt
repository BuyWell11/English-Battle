package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LdsWordSpellBinding


class LdsActivity : AppCompatActivity() {
    lateinit var binding : LdsWordSpellBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdsWordSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer_options: Array<String> = arrayOf("duck", "cat", "dog", "dragon")
        val task: String = "Кот"
        val right_answer:String = "cat"

        //Выводит слово, которое нужно перевести
        binding.task.text = task

        //Подписывает кнопки с вариантами ответов
        binding.answer1.text = answer_options[0]
        binding.answer2.text = answer_options[1]
        binding.answer3.text = answer_options[2]
        binding.answer4.text = answer_options[3]

        binding.answer1.setOnClickListener{
            val answer: String = binding.answer1.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

            ReturnToFight()
        }

        binding.answer2.setOnClickListener{
            val answer: String = binding.answer2.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

            ReturnToFight()
        }

        binding.answer3.setOnClickListener{
            val answer: String = binding.answer3.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

            ReturnToFight()
        }

        binding.answer4.setOnClickListener{
            val answer: String = binding.answer4.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

            ReturnToFight()
        }

    }

    private fun IsAnswerTrue(user_ans:String, right_ans:String): Boolean
    {
        return user_ans == right_ans
    }

    @SuppressLint("SetTextI18n")
    private fun ShowResult(result:Boolean)
    {
        binding.result.visibility = android.view.View.VISIBLE
        if(result)
        {
            binding.result.text = "You are right!"
        }
        else
        {
            binding.result.text = "You are wrong!"
        }
    }

    private fun ReturnToFight()
    {
        Handler(Looper.getMainLooper()).postDelayed( {
            //Переход на предыдущий слой
            super.onBackPressed()
        }, 1000)
    }
}