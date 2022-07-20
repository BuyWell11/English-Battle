package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.SignUpBinding
import kotlinx.android.parcel.Parcelize

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: SignUpBinding
    lateinit var state: State
    val dbManager = DatabaseManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dbManager.openDB()

        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            email = "",
            nickname = "",
            password = "",
            confpass = ""
        )

        binding.btnConf.setOnClickListener {
            val pass = binding.password.text.toString()
            val conf_pass = binding.confPassword.text.toString()
            if (!is_same_pass(pass, conf_pass)){
                binding.error.text = "пароли не совпадают"
                binding.error.visibility = android.view.View.VISIBLE
            }
            else{
                dbManager.insertIntoUsersTable(binding.nickname.text.toString(),
                    binding.password.text.toString(), binding.email.text.toString())
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onBackPressed() {

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }

    private fun is_same_pass(pass:String, conf_pass:String):Boolean {
        return pass == conf_pass
    }

    @Parcelize
    class State(
        var email: String?,
        var nickname: String?,
        var password: String?,
        var confpass: String?
    ) : Parcelable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
    }
}