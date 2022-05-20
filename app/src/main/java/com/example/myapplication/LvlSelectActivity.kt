package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.LvlSelectBinding
import kotlinx.android.parcel.Parcelize

class LvlSelectActivity : AppCompatActivity() {
    lateinit var binding: LvlSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LvlSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener{
            onLvl(1)
        }
        binding.btn2.setOnClickListener{
            onLvl(2)
        }
        binding.btn3.setOnClickListener{
            onLvl(3)
        }
    }

    private fun onLvl(lvl: Int) {
        val intent = Intent(this, FightActivity::class.java)
        intent.putExtra(FightActivity.ENEMY_PICS, lvl)
        startActivity(intent)
    }
}