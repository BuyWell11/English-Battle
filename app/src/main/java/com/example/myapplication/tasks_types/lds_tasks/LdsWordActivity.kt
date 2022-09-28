package com.example.myapplication.tasks_types.lds_tasks

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LdsWordSpellBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class LdsWordActivity : AppCompatActivity() {
    lateinit var binding : LdsWordSpellBinding

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdsWordSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var answerOptionsList : String = String()
        var rightAnswer : String = String()
        var skillTask : String = String()

        db.collection("LDS_Word")
            .whereEqualTo("skill_id", 1)
            .get()
            .addOnSuccessListener{result ->
                for (document in result)
                {
                    answerOptionsList = document.get("answer_options").toString()
                    rightAnswer = document.get("right_answer").toString()
                    skillTask = document.get("skill_task").toString()
                }
            }
            .addOnFailureListener{ result ->
                Log.d(TAG, "Shto-to poshlo ne tak")
            }
        //Выводит слово, которое нужно перевести
        binding.task.text = skillTask

        //Подписывает кнопки с вариантами ответов
        val answers = answerOptionsList.split(" ").toMutableList()

        binding.answer1.text = answers[0]
        binding.answer2.text = answers[1]
        binding.answer3.text = answers[2]
        binding.answer4.text = answers[3]

        binding.answer1.setOnClickListener{
            val answer: String = binding.answer1.text as String
            val result: Boolean = IsAnswerTrue(answer, rightAnswer)
            ShowResult(result)

        }

        binding.answer2.setOnClickListener{
            val answer: String = binding.answer2.text as String
            val result: Boolean = IsAnswerTrue(answer, rightAnswer)
            ShowResult(result)

        }

        binding.answer3.setOnClickListener{
            val answer: String = binding.answer3.text as String
            val result: Boolean = IsAnswerTrue(answer, rightAnswer)
            ShowResult(result)

        }

        binding.answer4.setOnClickListener{
            val answer: String = binding.answer4.text as String
            val result: Boolean = IsAnswerTrue(answer, rightAnswer)
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
            intent.putExtra(LdsPictureActivity.RIGHT, result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }, 1000)
    }


    companion object{
        @JvmStatic val RIGHT = "RIGHT"
    }
}