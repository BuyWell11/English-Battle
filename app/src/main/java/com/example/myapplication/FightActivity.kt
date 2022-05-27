package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.*
import android.view.View
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.FightBinding

import kotlinx.android.parcel.Parcelize

open class FightActivity : AppCompatActivity() {
    lateinit var binding:FightBinding
    lateinit var state: State
    lateinit var anim: Anim
    var anim_map = MapOfAnim

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MediaController(this)
        binding = FightBinding.inflate(layoutInflater)
        get_anim(intent.getIntExtra(ENEMY_PICS, 0))
        binding.monster.setImageResource(anim.stand)
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
        state = savedInstanceState?.getParcelable(KEY_STATE) ?: State(
            hp = 100,
            boss_hp = 1000
        )

    }

    private fun onLDSpressed()
    {
        val random = (0..1).random()
        if (random == 0) {
            val intent = Intent(this, LdsWordActivity::class.java)
            startActivityIfNeeded(intent, LOW_DMG_REQUEST_CODE)
        }
        else if(random == 1)
        {
            val intent = Intent(this, LdsPictureActivity::class.java)
            startActivityIfNeeded(intent, LOW_DMG_REQUEST_CODE)
        }
    }

    private fun onMDSpressed()
    {
        val random = (0..100).random()
        if (random < 50) {
            val intent = Intent(this, MdsMakeSentenceActivity::class.java)
            startActivityIfNeeded(intent, MID_DMG_REQUEST_CODE)
        }
        else if(random > 50) {
            val intent = Intent(this, MdsMakeWordActivity::class.java)
            startActivityIfNeeded(intent, MID_DMG_REQUEST_CODE)
        }
    }

    private fun onHDSpressed()
    {
        val random = (0..1).random()
        if (random == 0) {
            val intent = Intent(this, HdsTranslationActivity::class.java)
            startActivityIfNeeded(intent, HIGH_DMG_REQUEST_CODE)
        }
        else if(random == 1) {
            val intent = Intent(this, HdsChooseWordActivity::class.java)
            startActivityIfNeeded(intent, HIGH_DMG_REQUEST_CODE)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_STATE, state)
    }

    private fun renderState() = with(binding) {
        monsterhp.text = "HP: ${state.boss_hp}/1000"
        wizhp.text = "HP: ${state.hp}/100"
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var temp_bool:Boolean
        var right = data?.getBooleanExtra(LdsPictureActivity.RIGHT, false)
        when(requestCode){
            LOW_DMG_REQUEST_CODE -> {
                if(right == true){
                    state.boss_hp -= 100
                    binding.monster.setImageResource(anim.take_dmg)
                }
                else{
                    state.hp -= 20
                    binding.monster.setImageResource(anim.attack)
                }
        }
            MID_DMG_REQUEST_CODE ->{
                if(right == true){
                    state.boss_hp -= 250
                    binding.monster.setImageResource(anim.take_dmg)
                }
                else{
                    state.hp -= 20
                    binding.monster.setImageResource(anim.attack)
                }
            }
            HIGH_DMG_REQUEST_CODE ->{
                if(right == true){
                    state.boss_hp -= 400
                    binding.monster.setImageResource(anim.take_dmg)
                }
                else{
                    state.hp -= 20
                    binding.monster.setImageResource(anim.attack)
                }
            }
        }
        binding.monster.setImageResource(anim.stand)
        renderState()
        if(state.hp <= 0){
            temp_bool = true
            fight_finish(temp_bool)
        }
        else if(state.boss_hp <= 0){
            temp_bool = false
            fight_finish(temp_bool)
        }
    }

    private fun fight_finish(dead:Boolean){
        if (dead){
            binding.monster.setImageResource(anim.stand)
        }
        else{
            binding.monster.setImageResource(anim.dead)
        }
        Handler(Looper.getMainLooper()).postDelayed( {
            var intent = Intent(this, Win_lossActivity::class.java)
            intent.putExtra(Win_lossActivity.RESULT, dead)
            startActivity(intent)
            finish()
        }, 2000)
    }

    private fun get_anim(enemy : Int){
        anim = anim_map[enemy]!!
    }

    @Parcelize
    class State(
        var hp: Int,
        var boss_hp: Int
    ) : Parcelable

    @Parcelize
    class Anim(
        var stand: Int,
        var attack: Int,
        var take_dmg: Int,
        var dead: Int
    ) : Parcelable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
        @JvmStatic val ENEMY_PICS = "ANIM"
        @JvmStatic private val LOW_DMG_REQUEST_CODE = 1
        @JvmStatic private val MID_DMG_REQUEST_CODE = 2
        @JvmStatic private val HIGH_DMG_REQUEST_CODE = 3
    }
}