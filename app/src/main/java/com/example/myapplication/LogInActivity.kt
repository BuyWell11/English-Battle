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
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.parcel.Parcelize


class LogInActivity : AppCompatActivity() {
    lateinit var binding: LogInBinding
    lateinit var state: State
    val dbManager = DatabaseManager(this)
    lateinit var sharedPref: SharedPreferences

    //FIREBASE
    lateinit var mAuth : FirebaseAuth
    //FIREBASE

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

        //FIREBASE
        mAuth = FirebaseAuth.getInstance()
        //FIREBASE

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            email = "",
            password = "",
        )

        binding.btnLog.setOnClickListener {
            //FIREBASE
            mAuth.signInWithEmailAndPassword(binding.email.text.toString(), binding.password.text.toString()).addOnCompleteListener{ task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    val editor = sharedPref.edit()
                    editor.putString("Login", "123")
                    editor.putString("Password", "123")
                    editor.apply()
                    startActivity(intent)
                }
                else
                {
                    binding.error.text = "Неверный логин или пароль\nИли такого пользователя не существует"
                    binding.error.visibility = android.view.View.VISIBLE
                }
            }
            //FIREBASE
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