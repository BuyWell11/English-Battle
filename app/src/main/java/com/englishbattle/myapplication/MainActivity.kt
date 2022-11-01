package com.englishbattle.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.MainMenuBinding
import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.common.AdRequest


class MainActivity : AppCompatActivity() {
    lateinit var binding: MainMenuBinding
    lateinit var sharedPref: SharedPreferences

    var db = Firebase.firestore
    var currentLvl : Int = 0
    val user = Firebase.auth.currentUser
    val email = user?.email

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Загруска полноэкранной рекламы
        val interstitialAdsManager : InterstitialAds = InterstitialAds()
        interstitialAdsManager.loadAndShowAd(this)

        binding = MainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPref = getSharedPreferences("PREFERENCE", Context.MODE_PRIVATE)

        db.collection("User")
            .whereEqualTo("user_email", email)
            .get()
            .addOnSuccessListener { result ->
                for (document in result)
                {
                    currentLvl = document.get("current_lvl").toString().toInt()
                }
            }

        binding.btn1.setOnClickListener{
            onPlayPressed(currentLvl)
        }
        binding.btn2.setOnClickListener{
            onSelectPressed()
        }
        binding.btn3.setOnClickListener{
            onExitPressed()
        }

        val banner = binding.banner
        banner.setAdUnitId("R-M-1973138-3")
        banner.setAdSize(AdSize.BANNER_320x50)
        val adRequest = AdRequest.Builder().build()

        banner.loadAd(adRequest)

    }

    private fun onPlayPressed(currentLvl : Int){
        val intent = Intent(this, LvlSelectActivity::class.java)
        intent.putExtra("CURRENT_LEVEL", currentLvl)
        startActivity(intent)
    }

    private fun onSelectPressed(){
        val intent = Intent(this, SelectActivity::class.java)
        startActivity(intent)
    }

    private fun onExitPressed(){
        FirebaseAuth.getInstance().signOut()
        finish()
    }
}