package com.englishbattle.myapplication

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.LvlSelectBinding
import kotlinx.android.synthetic.main.lvl_select.*


var currentLvl : Int = 0

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
        binding.btn4.setOnClickListener{
            onLvl(4)
        }
        binding.btn5.setOnClickListener{
            onLvl(5)
        }
    }

    var getAction = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        chooseCurrentLvl(currentLvl)
    }

    private fun onLvl(lvl: Int) {
        val intent = Intent(this, FightActivity::class.java)
        intent.putExtra(FightActivity.ENEMY_PICS, lvl)
        intent.putExtra(FightActivity.PLAYER_PICS, 0)
        getAction.launch(intent)
        finish()
    }

    private fun chooseCurrentLvl(currentLvl : Int)
    {
        val buttons = ArrayList<Button>()
        for (i in 1..5) {
            val idString = "btn$i"
            val buttonID = resources.getIdentifier(idString, "id", packageName)
            buttons.add(findViewById(buttonID))
            if (i == currentLvl){
                buttons[i-1].isEnabled = true
            }
        }
    }

    companion object {
        @JvmStatic private val CURRENT_LEVEL = "CURRENT_LEVEL"
    }
}