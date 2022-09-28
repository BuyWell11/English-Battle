package com.example.myapplication.tasks_types.lds_tasks

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.LdsPictureSpellBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.lds_picture_spell.*


class LdsPictureActivity : AppCompatActivity() {
    lateinit var binding: LdsPictureSpellBinding

    val dbManager = DatabaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdsPictureSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager.openDB()
        val datalist = dbManager.GetLdsPictureInfo()

        val right_answer:String = datalist[1]

        Picasso.get().load(datalist[0]).into(image_task)

        //Подписывает кнопки с вариантами ответов
        val answers = datalist[2].split(" ").toMutableList()

        binding.answer1.text = answers[0]
        binding.answer2.text = answers[1]
        binding.answer3.text = answers[2]
        binding.answer4.text = answers[3]

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

    override fun onBackPressed() {

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

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }
}