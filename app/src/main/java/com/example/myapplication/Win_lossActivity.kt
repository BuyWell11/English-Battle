package com.example.myapplication

import android.content.ContentValues.TAG
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.myapplication.databinding.WinLossScreenBinding
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.lang.IllegalArgumentException

class Win_lossActivity : AppCompatActivity() {
    lateinit var binding: WinLossScreenBinding
    var dead: Boolean = false

    var db = Firebase.firestore
    val user : FirebaseUser? = Firebase.auth.currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WinLossScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dead = intent?.getBooleanExtra(RESULT, false)?:
        throw IllegalArgumentException("CHZH")
        if(dead)
        {
            binding.result.setTextColor(Color.parseColor("#ff0000"))
            binding.result.text = "You're dead"
        }
        else
        {
            binding.result.text = "You won!"

            currentLvl += 1

            user?.let {
                val userEmail = user.email

                db.collection("User")
                    .document("g3pVwYbHs29OiWJ1cQQ3")
                    .update("current_lvl", currentLvl)
                    .addOnSuccessListener {
                        Log.d(TAG, "Current level successfully updated!")
                    }
                    .addOnFailureListener {
                            e -> Log.w(TAG, "Error updating document", e)
                    }
            }
        }
        Handler(Looper.getMainLooper()).postDelayed( {
            finish()
        }, 2000)
    }

    companion object{
        @JvmStatic val RESULT = "RESULT"
    }
}
