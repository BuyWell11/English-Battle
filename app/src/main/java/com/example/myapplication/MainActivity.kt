package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.MainMenuBinding
import okhttp3.*
import java.io.IOException
import java.sql.ResultSet


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainMenuBinding
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val db  = Database()
        run("http://217.25.230.151:3000")
        val a = 1


        binding.btn1.setOnClickListener{
            onPlayPressed()
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

    private fun onPlayPressed(){
        val intent = Intent(this, LvlSelectActivity::class.java)
        startActivity(intent)
    }

    private fun onSelectPressed(){
        val intent = Intent(this, SelectActivity::class.java)
        startActivity(intent)
    }

    private fun onExitPressed(){
        finish()
    }

}