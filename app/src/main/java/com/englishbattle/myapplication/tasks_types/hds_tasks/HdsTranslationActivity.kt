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
import com.example.myapplication.databinding.HdsTranslationSpellBinding
import com.englishbattle.myapplication.tasks_types.lds_tasks.LdsPictureActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HdsTranslationActivity : AppCompatActivity() {
    lateinit var binding: HdsTranslationSpellBinding

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HdsTranslationSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var rightAnswer : String = String()
        var skillTask : String = String()

        db.collection("HDS_translation")
            .whereEqualTo("skill_id", (1..TasksQuantity.HDS_TRANSLATION_MAX).random())
            .get()
            .addOnSuccessListener { result ->
                for (document in result)
                {
                    binding.task.text = document.get("skill_task").toString()

                    rightAnswer = document.get("right_answer").toString()
                }
            }
            .addOnFailureListener{ result ->
                Log.d(ContentValues.TAG, "Shto-to poshlo ne tak")
            }

        binding.DoneBtn.setOnClickListener{
            val keyword = binding.answerSpace.text.toString()
            val result: Boolean = IsAnswerTrue(keyword, rightAnswer)
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