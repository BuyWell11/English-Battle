package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.MainMenuBinding
import okhttp3.*
import java.io.IOException
import android.content.SharedPreferences
import com.example.myapplication.database.DatabaseManager


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainMenuBinding
    private val client = OkHttpClient()
    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

        //val db  = Database()
        run("http://217.25.230.151:3000")
        val a = 1

        val dbManager = DatabaseManager(this)
        dbManager.openDB()

        val currentLvl = 1
        //var currentLvl = dbManager.GetCurrentLvl()

        dbManager.closeDB()

        binding.btn1.setOnClickListener{
            onPlayPressed(currentLvl)
        }
        binding.btn2.setOnClickListener{
            onSelectPressed()
        }
        binding.btn3.setOnClickListener{
            onExitPressed()
        }
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }

    private fun onPlayPressed(currentLvl : Int){
        val intent = Intent(this, LvlSelectActivity::class.java)
        intent.putExtra("CURRENT_LEVEL", currentLvl)
        startActivity(intent)
    }

    private fun onSelectPressed(){
        val intent = Intent(this, SelectActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("CommitPrefEdits")
    private fun onExitPressed(){
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
        finish()
    }

}