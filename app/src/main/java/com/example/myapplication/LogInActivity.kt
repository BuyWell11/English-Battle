package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.LogInBinding
import kotlinx.android.parcel.Parcelize

class LogInActivity : AppCompatActivity() {
    lateinit var binding: LogInBinding
    lateinit var state: State
    val dbManager = DatabaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager.openDB()

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            email = "",
            password = "",
        )

        binding.btnLog.setOnClickListener {
            if (dbManager.isUserExist(binding.email.text.toString(), binding.password.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else{
                binding.error.text = "Неверный логин или пароль\nИли такого пользователя не существует"
            }
        }
        binding.btnSign.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }

    @Parcelize
    class State(
        var email: String?,
        var password: String?
    ) : Parcelable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
    }
}