package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.LvlSelectBinding

class LvlSelectActivity : AppCompatActivity() {
    lateinit var binding: LvlSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LvlSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener{
            onLvl(it)
        }
        binding.btn2.setOnClickListener{
            onLvl(it)
        }
        binding.btn3.setOnClickListener{
            onLvl(it)
        }
    }

    private fun onLvl(lvl: View) {
        when(lvl.id){
            binding.btn1.id -> {
                val intent = Intent(this, FightActivity::class.java)
                startActivity(intent)
            }
            binding.btn2.id -> {

            }
            binding.btn3.id -> {

            }
        }
    }
}