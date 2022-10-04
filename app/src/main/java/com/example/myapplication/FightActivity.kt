package com.example.myapplication

import android.content.Intent
import android.os.*
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.FightBinding
import com.example.myapplication.tasks_types.hds_tasks.HdsChooseWordActivity
import com.example.myapplication.tasks_types.hds_tasks.HdsTranslationActivity
import com.example.myapplication.tasks_types.lds_tasks.LdsPictureActivity
import com.example.myapplication.tasks_types.lds_tasks.LdsWordActivity
import com.example.myapplication.tasks_types.mds_tasks.MdsMakeSentenceActivity
import com.example.myapplication.tasks_types.mds_tasks.MdsMakeWordActivity

import kotlinx.android.parcel.Parcelize

open class FightActivity : AppCompatActivity() {
    lateinit var binding:FightBinding
    lateinit var state: State
    lateinit var anim: Anim
    lateinit var playerAnim: PlayerAnim
    var animMap = MapOfAnim
    var playerAnimMap = MapOfPlayerAnim

    val LDS_BOSS_DMG = 100
    val LDS_PLAYER_DMG = 20
    val MDS_BOSS_DMG = 250
    val MDS_PLAYER_DMG = 20
    val HDS_BOSS_DMG = 400
    val HDS_PLAYER_DMG = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MediaController(this)
        binding = FightBinding.inflate(layoutInflater)
        getEnemyAnim(intent.getIntExtra(ENEMY_PICS, 0))
        getPlayerAnim(intent.getIntExtra(PLAYER_PICS, 0))
        binding.monster.setImageResource(anim.stand)
        binding.wizard.setImageResource(playerAnim.stand)
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
        val random = (0..100).random()
        if (random < 50)
        {
            val intent = Intent(this, LdsWordActivity::class.java)
            startActivityIfNeeded(intent, LOW_DMG_REQUEST_CODE)
        }
        else if(random > 50)
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
        val random = (0..100).random()
        if (random < 50) {
            val intent = Intent(this, HdsTranslationActivity::class.java)
            startActivityIfNeeded(intent, HIGH_DMG_REQUEST_CODE)
        }
        else if(random > 50) {
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
        var tempBool:Boolean
        var right = data?.getBooleanExtra(LdsPictureActivity.RIGHT, false)
        when(requestCode){
            LOW_DMG_REQUEST_CODE -> {
                if(right == true){
                    if (state.boss_hp - LDS_BOSS_DMG > 0)
                    {
                        state.boss_hp -= LDS_BOSS_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.take_dmg)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.boss_hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.lds_spell_attack)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
                else{

                    if (state.hp - LDS_PLAYER_DMG > 0)
                    {
                        state.hp -= LDS_PLAYER_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.attack)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.take_dmg)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
        }
            MID_DMG_REQUEST_CODE ->{
                if(right == true){

                    if (state.boss_hp - MDS_BOSS_DMG > 0)
                    {
                        state.boss_hp -= MDS_BOSS_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.take_dmg)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.boss_hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.mds_spell_attack)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
                else{

                    if (state.hp - MDS_PLAYER_DMG > 0)
                    {
                        state.hp -= MDS_PLAYER_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.attack)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.take_dmg)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
            }
            HIGH_DMG_REQUEST_CODE ->{
                if(right == true){

                    if (state.boss_hp - HDS_BOSS_DMG > 0)
                    {
                        state.boss_hp -= HDS_BOSS_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.take_dmg)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.boss_hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.hds_spell_attack)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
                else{

                    if (state.hp - HDS_PLAYER_DMG > 0)
                    {
                        state.hp -= HDS_PLAYER_DMG

                        //Enemy animation
                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.attack)
                        }, 500)

                        Handler(Looper.getMainLooper()).postDelayed( {
                            binding.monster.setImageResource(anim.stand)
                        }, 2000)
                    }
                    else
                    {
                        state.hp = 0;
                    }

                    //Player animation
                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.take_dmg)
                    }, 500)

                    Handler(Looper.getMainLooper()).postDelayed( {
                        binding.wizard.setImageResource(playerAnim.stand)
                    }, 2000)
                }
            }
        }
        binding.monster.setImageResource(anim.stand)
        binding.wizard.setImageResource(playerAnim.stand)
        renderState()

        if(state.hp == 0){
            disableSkills()
            tempBool = true
            fightFinish(tempBool)
        }
        else if(state.boss_hp == 0){
            disableSkills()
            tempBool = false
            fightFinish(tempBool)
        }
    }

    private fun disableSkills() {
        binding.lowdmg.isEnabled = false
        binding.middmg.isEnabled = false
        binding.highdmg.isEnabled = false
    }

    private fun fightFinish(dead:Boolean){
        if (!dead) {
            Handler(Looper.getMainLooper()).postDelayed( {
                binding.monster.setImageResource(anim.dead)
            }, 1000)
        }

        Handler(Looper.getMainLooper()).postDelayed( {
            var intent = Intent(this, Win_lossActivity::class.java)
            intent.putExtra(Win_lossActivity.RESULT, dead)
            startActivity(intent)
            finish()
        }, 2000)
    }

    private fun getEnemyAnim(enemy : Int){
        anim = animMap[enemy]!!
    }

    private fun getPlayerAnim(player : Int){
        playerAnim = playerAnimMap[player]!!
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

    @Parcelize
    class PlayerAnim(
        var stand: Int,
        var lds_spell_attack: Int,
        var mds_spell_attack: Int,
        var hds_spell_attack: Int,
        var take_dmg: Int,
        var win: Int
    ) : Parcelable

    companion object {
        @JvmStatic private val KEY_STATE = "STATE"
        @JvmStatic val ENEMY_PICS = "ANIM"
        @JvmStatic val PLAYER_PICS = "PLAYER_ANIM"
        @JvmStatic private val LOW_DMG_REQUEST_CODE = 1
        @JvmStatic private val MID_DMG_REQUEST_CODE = 2
        @JvmStatic private val HIGH_DMG_REQUEST_CODE = 3
    }
}