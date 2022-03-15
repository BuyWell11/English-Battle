package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.LdsSpellBinding

class LdsActivity : AppCompatActivity() {
    lateinit var binding : LdsSpellBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LdsSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}