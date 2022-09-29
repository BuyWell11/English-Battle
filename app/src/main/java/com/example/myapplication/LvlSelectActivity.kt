package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.myapplication.databinding.LvlSelectBinding
import kotlinx.android.synthetic.main.lvl_select.*

var currentLvl : Int = -1

class LvlSelectActivity : AppCompatActivity() {
    lateinit var binding: LvlSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LvlSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currentLvl = intent.getIntExtra(CURRENT_LEVEL, 0)
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

    var getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //UpdateCurrentLvl()
        chooseCurrentLvl(currentLvl)
    }

    private fun onLvl(lvl: Int) {
        val intent = Intent(this, FightActivity::class.java)
        intent.putExtra(FightActivity.ENEMY_PICS, lvl)
        getAction.launch(intent)
    }

    private fun chooseCurrentLvl(currentLvl : Int)
    {
        when(currentLvl % 3)
        {
            0 -> {
                btn1.isEnabled = true
                btn2.isEnabled = false
                btn3.isEnabled = false
            }
            1 -> {
                btn1.isEnabled = false
                btn2.isEnabled = true
                btn3.isEnabled = false
            }
            2 -> {
                btn1.isEnabled = false
                btn2.isEnabled = false
                btn3.isEnabled = true
            }
        }
    }

    companion object {
        @JvmStatic private val CURRENT_LEVEL = "CURRENT_LEVEL"
    }
}