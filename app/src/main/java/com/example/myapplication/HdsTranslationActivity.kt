package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.HdsTranslationSpellBinding
import kotlin.properties.Delegates


class HdsTranslationActivity : AppCompatActivity() {
    lateinit var binding: HdsTranslationSpellBinding

    private var result: Boolean = false
    val dbManager = DatabaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HdsTranslationSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager.openDB()
        val datalist = dbManager.GetHdsTranslationInfo()

        val right_answer: String = datalist[1]

        //Выводит слово, которое нужно перевести
        binding.task.text = datalist[0]

        binding.DoneBtn.setOnClickListener{
            val keyword = binding.answerSpace.text.toString()
            val result: Boolean = IsAnswerTrue(keyword, right_answer)
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

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }
}