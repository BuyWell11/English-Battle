package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
    import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.LogInBinding
import kotlinx.android.parcel.Parcelize


class LogInActivity : AppCompatActivity() {
    lateinit var binding: LogInBinding
    lateinit var state: State
    val dbManager = DatabaseManager(this)
    lateinit var sharedPref: SharedPreferences



    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

        dbManager.openDB()

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            email = "",
            password = "",
        )

        check_log_in()

        binding.btnLog.setOnClickListener {
            if (dbManager.isUserExist(binding.email.text.toString(), binding.password.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                val editor = sharedPref.edit()
                editor.putString("Login", binding.email.text.toString())
                editor.putString("Password", binding.password.text.toString())
                editor.apply()
                startActivity(intent)
            }
            else{
                binding.error.text = "Неверный логин или пароль\nИли такого пользователя не существует"
                binding.error.visibility = android.view.View.VISIBLE
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

    fun check_log_in(){
        val temp_log = sharedPref.getString("Login", "").toString()
        val temp_pass = sharedPref.getString("Password", "").toString()

        if (dbManager.isUserExist(temp_log, temp_pass)){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
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