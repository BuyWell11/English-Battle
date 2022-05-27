package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.WinLossScreenBinding
import java.lang.IllegalArgumentException

class Win_lossActivity : AppCompatActivity() {
    lateinit var binding: WinLossScreenBinding
    var dead: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinLossScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dead = intent?.getBooleanExtra(RESULT, false)?:
        throw IllegalArgumentException("CHZH")
        if(dead)
        {
            binding.result.setTextColor(Color.parseColor("#ff0000"))
            binding.result.text = "You're dead"
        }
        else
        {
            binding.result.text = "You won!"

            val dbManager = DatabaseManager(this)
            dbManager.openDB()

            dbManager.updateCurrentLvl()

            dbManager.closeDB()
        }
        Handler(Looper.getMainLooper()).postDelayed( {
            finish()
        }, 2000)
    }

    companion object{
        @JvmStatic val RESULT = "RESULT"
    }
}
