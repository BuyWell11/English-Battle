package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LdsPictureSpellBinding


class LdsPictureActivity : AppCompatActivity() {
    lateinit var binding: LdsPictureSpellBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdsPictureSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val answer_options: Array<String> = arrayOf("chel", "monster", "wizard", "loh")
        val right_answer:String = "wizard"

        //Выводит картинку, которую нужно перевести
        binding.imageTask.setImageResource(R.drawable.wizard)

        //Подписывает кнопки с вариантами ответов
        binding.answer1.text = answer_options[0]
        binding.answer2.text = answer_options[1]
        binding.answer3.text = answer_options[2]
        binding.answer4.text = answer_options[3]

        binding.answer1.setOnClickListener{
            val answer: String = binding.answer1.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

        }

        binding.answer2.setOnClickListener{
            val answer: String = binding.answer2.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

        }

        binding.answer3.setOnClickListener{
            val answer: String = binding.answer3.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

        }

        binding.answer4.setOnClickListener{
            val answer: String = binding.answer4.text as String
            val result: Boolean = IsAnswerTrue(answer, right_answer)
            ShowResult(result)

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
        Handler(Looper.getMainLooper()).postDelayed( {
            val intent = Intent()
            intent.putExtra(RIGHT, result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }, 1000)
    }

    companion object{
        @JvmStatic val RIGHT = "RIGHT"
    }
}