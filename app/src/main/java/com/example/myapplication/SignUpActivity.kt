package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Parcelable
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.SignUpBinding
import kotlinx.android.parcel.Parcelize

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: SignUpBinding
    lateinit var state: State
    var email: String? = null
    var nick: String? = null
    var pass: String? = null
    var confpass: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.email.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE){
                email = binding.email.text.toString()
                state.email = email
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.nickname.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE){
                nick = binding.nickname.text.toString()
                state.nickname = nick
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.password.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE){
                pass = binding.password.text.toString()
                state.password = pass
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.confPassword.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE){
                confpass = binding.confPassword.text.toString()
                state.confpass = confpass
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
        binding.btnConf.setOnClickListener {
            if (state.password != state.confpass){
                binding.error.text = "пароли не совпадают"
                binding.error.visibility = android.view.View.VISIBLE
                Handler(Looper.getMainLooper()).postDelayed( {
                    recreate()
                }, 2000)
            }
            else{
                val intent = Intent(this, LogInActivity::class.java)
                startActivity(intent)
            }
        }
        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            email = "",
            nickname = "",
            password = "",
            confpass = ""
        )
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
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