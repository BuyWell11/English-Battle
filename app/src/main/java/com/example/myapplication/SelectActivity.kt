package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.myapplication.databinding.UserSelectBinding

class SelectActivity : AppCompatActivity() {
    lateinit var binding: UserSelectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = UserSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener{
            press_butt(it)
        }
        binding.btn2.setOnClickListener{
            press_butt(it)
        }
        binding.btn3.setOnClickListener{
            press_butt(it)
        }
    }


    private fun press_butt(butt: View) {
        when (butt.id){
            binding.btn1.id ->{
                if(binding.btn1.text.toString() == "New Character"){
                    binding.frames.visibility = View.VISIBLE
                    val name = binding.nameInput.text.toString()
                    if (name.isBlank()){
                        binding.nameInput.error = "No name"
                        return
                    }
                    binding.btn1.text = name
                    binding.frames.visibility = View.GONE
                }
            }
            binding.btn2.id ->{
                if(binding.btn2.text.toString() == "New Character"){
                    binding.frames.visibility = View.VISIBLE
                    val name = binding.nameInput.text.toString()
                    if (name.isBlank()){
                        binding.nameInput.error = "No name"
                        return
                    }
                    binding.btn1.text = name
                    binding.frames.visibility = View.GONE
                }
            }
            binding.btn3.id ->{
                if(binding.btn3.text.toString() == "New Character"){
                    binding.frames.visibility = View.VISIBLE
                    val name = binding.nameInput.text.toString()
                    if (name.isBlank()){
                        binding.nameInput.error = "No name"
                        return
                    }
                    binding.btn1.text = name
                    binding.frames.visibility = View.GONE
                }
            }
        }
    }
}