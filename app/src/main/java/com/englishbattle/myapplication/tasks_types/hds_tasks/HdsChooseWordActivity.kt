package com.englishbattle.myapplication.tasks_types.hds_tasks

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.englishbattle.myapplication.TasksQuantity
import com.example.myapplication.databinding.HdsChooseWordSpellBinding
import com.englishbattle.myapplication.tasks_types.lds_tasks.LdsPictureActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HdsChooseWordActivity : AppCompatActivity() {
    lateinit var binding : HdsChooseWordSpellBinding

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HdsChooseWordSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var answerOptionsList : MutableList<String> = mutableListOf()
        var rightAnswer : String = String()
        var skillTask : String = String()

        db.collection("HDS_choose_word")
            .whereEqualTo("skill_id", (1..TasksQuantity.HDS_CHOOSE_WORD_MAX).random())
            .get()
            .addOnSuccessListener { result ->
                for (document in result)
                {
                    binding.task.text = document.get("skill_task").toString()

                    answerOptionsList = document.get("answer_options").toString().split(" ").toMutableList()
                    binding.answer1.text = answerOptionsList[0]
                    binding.answer2.text = answerOptionsList[1]
                    binding.answer3.text = answerOptionsList[2]
                    binding.answer4.text = answerOptionsList[3]

                    rightAnswer = document.get("right_answer").toString()
                }
            }
            .addOnFailureListener{ result ->
                Log.d(ContentValues.TAG, "Shto-to poshlo ne tak")
            }

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

    private fun IsAnswerTrue(userAnswer:String, rightAnswer:String): Boolean
    {
        return userAnswer == rightAnswer
    }

    @SuppressLint("SetTextI18n")
    private fun ShowResult(result:Boolean)
    {
        binding.result.visibility = android.view.View.VISIBLE
        if(result)
        {
            binding.result.text = "Верно!"
        }
        else
        {
            binding.result.text = "Неверно!"
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