package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.LvlSelectBinding
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.lvl_select.*

class LvlSelectActivity : AppCompatActivity() {
    lateinit var binding: LvlSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LvlSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dbManager = DatabaseManager(this)
        dbManager.openDB()

        val currentLvl = dbManager.GetCurrentLvl()

        dbManager.closeDB()

        chooseCurrentLvl(currentLvl)

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

    private fun chooseCurrentLvl(currentLvl : Int)
    {
        when(currentLvl)
        {
            1 -> btn1.isEnabled = true
            2 -> btn2.isEnabled = true
            3 -> btn3.isEnabled = true
        }
    }
}