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
        val intent = Intent(this, FightActivity::class.java)
        intent.putExtra(FightActivity.ENEMY_PICS, lvl.id)
        startActivity(intent)
    }
}