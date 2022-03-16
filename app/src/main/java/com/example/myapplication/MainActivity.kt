package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.MainMenuBinding
import com.example.myapplication.Database

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db  = Database()

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