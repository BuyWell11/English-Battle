package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.MainMenuBinding
import java.sql.ResultSet

class MainActivity : AppCompatActivity() {
    lateinit var binding: MainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db  = Database()
        var rs: ResultSet
        object : Thread() {
            override fun run() {
                rs = db.GetTaskLDS()
            }
        }.start()
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