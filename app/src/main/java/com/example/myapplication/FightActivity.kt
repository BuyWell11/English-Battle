package com.example.myapplication

import android.content.Intent
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
            onLDSpressed()
        }
        binding.middmg.setOnClickListener{
            onMDSpressed()
        }
        binding.highdmg.setOnClickListener{
            onHDSpressed()
        }
        binding.mana.setOnClickListener{

        }
    }

    private fun onLDSpressed()
    {
        val random = (0..1).random()
        if (random == 0) {
            val intent = Intent(this, LdsWordActivity::class.java)
            startActivity(intent)
        }
        else if(random == 1)
        {
            val intent = Intent(this, LdsPictureActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onMDSpressed()
    {

    }

    private fun onHDSpressed()
    {
        val intent = Intent(this, HdsChooseWordActivity::class.java)
        startActivity(intent)
    }
}