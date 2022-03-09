package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.FightBinding

class FightActivity : AppCompatActivity() {
    lateinit var binding:FightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FightBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lowdmg.setOnClickListener{

        }
        binding.middmg.setOnClickListener{

        }
        binding.highdmg.setOnClickListener{

        }
        binding.mana.setOnClickListener{

        }
    }
}