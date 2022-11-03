package com.englishbattle.myapplication.signUP_signIN

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.SignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.parcel.Parcelize

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: SignUpBinding
    lateinit var state: State

    //FIREBASE
    lateinit var mAuth : FirebaseAuth
    lateinit var db : FirebaseFirestore
    //FIREBASE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //FIREBASE
        mAuth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()
        //FIREBASE

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
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_LONG).show()
            }
            else if(binding.email.text.toString().length < 6){
                Toast.makeText(baseContext, "Input a password of 6 characters or more",
                    Toast.LENGTH_SHORT).show()
            }
            else{
                //FIREBASE
                val user : HashMap<String, Any> = hashMapOf("user_name" to binding.nickname.text.toString(),
                                                            "user_email" to binding.email.text.toString(),
                                                            "user_avatar" to "-",
                                                            "current_lvl" to 1)

                mAuth.createUserWithEmailAndPassword(binding.email.text.toString(), binding.password.text.toString()).addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        db.collection("User").document(binding.email.text.toString()).set(user)
                        finish()
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
                //FIREBASE
            }
        }
    }

    override fun onBackPressed() {
        finish()
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