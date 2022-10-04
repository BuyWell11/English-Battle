package com.example.myapplication

import com.example.myapplication.FightActivity.Anim
import com.example.myapplication.FightActivity.PlayerAnim

val MapOfAnim = mutableMapOf(
    1 to Anim(R.drawable.slime, R.drawable.slime_attack, R.drawable.slime_takedmg, R.drawable.slime_dead),
    2 to Anim(R.drawable.scorpion, R.drawable.scorpion_attack, R.drawable.scorpion_takedmg, R.drawable.scorpion_dead),
    3 to Anim(R.drawable.skeleton, R.drawable.skeleton_attack, R.drawable.skeleton_takedmg, R.drawable.skeleton_dead),
    4 to Anim(R.drawable.minotaur, R.drawable.minotaur_attack, R.drawable.minotaur_takedmg, R.drawable.minotaur_dead),
    5 to Anim(R.drawable.minotaur, R.drawable.minotaur_attack, R.drawable.minotaur_takedmg, R.drawable.minotaur_dead)
)

val MapOfPlayerAnim = mutableMapOf(
    0 to PlayerAnim(R.drawable.wiz, R.drawable.wiz_lspel, R.drawable.wiz_mspel, R.drawable.wiz_hspel, R.drawable.wiz_takedmg, R.drawable.wiz_win)
)