package com.example.myapplication.tasks_types.mds_tasks

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.database.DatabaseManager
import com.example.myapplication.databinding.MdsMakeSentenceSpellBinding
import com.example.myapplication.tasks_types.lds_tasks.LdsPictureActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.mutableListOf

class MdsMakeWordActivity : AppCompatActivity() {
    lateinit var binding: MdsMakeSentenceSpellBinding

    private var list = mutableListOf<String>()
    private lateinit var adapter : MdsAdapter
    private lateinit var recyclerView: RecyclerView

    val db = Firebase.firestore

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MdsMakeSentenceSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = linearLayoutManager

        var right_answer = String()
        var letterList = String()
        var skillTask = String()

        db.collection("MDS_make_word")
            .whereEqualTo("skill_id", 1)
            .get()
            .addOnSuccessListener{result ->
                for (document in result)
                {
                    skillTask = document.get("skill_task").toString()
                    binding.task.text = "Make word '${skillTask}' using these letters:"

                    letterList = document.get("letter_list").toString()
                    /*adapter = MdsAdapter(wordList.split(" ").toMutableList())
                    recyclerView.adapter = adapter
                    val itemTouchHelper = ItemTouchHelper(simpleCallback)
                    itemTouchHelper.attachToRecyclerView(recyclerView)*/

                    right_answer = document.get("right_answer").toString()
                }
            }
            .addOnFailureListener{ result ->
                Log.d(ContentValues.TAG, "Shto-to poshlo ne tak")
            }

        list = letterList.split(" ").toMutableList()
        adapter = MdsAdapter(list)
        recyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        binding.enterBtn.setOnClickListener{
            val keyword : String = MakeAnswer()
            val result: Boolean = IsAnswerTrue(keyword, right_answer)
            ShowResult(result)
        }
    }

    override fun onBackPressed() {

    }

    private val simpleCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or
            ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, 0)
    {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder) : Boolean
        {
            val fromPosition = viewHolder.adapterPosition
            val toPosition = target.adapterPosition

            swap(list, fromPosition, toPosition)

            recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)

            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }
    }

    fun <T> swap(list: MutableList<T>, i: Int, j: Int) {
        val t = list[i]
        list[i] = list[j]
        list[j] = t
    }

    fun fetchData() : ArrayList<String>
    {
        val list = ArrayList<String>()
        for (i in 0..2)
        {
            list.add("word " + i)
        }
        return list
    }

    private fun MakeAnswer() : String
    {
        val user_answer = StringBuilder()
        for (i in 0..list.size-1)
        {
            user_answer.append(list[i])
        }

        return user_answer.toString()
    }

    private fun IsAnswerTrue(user_ans:String, right_ans:String): Boolean
    {
        return user_ans == right_ans
    }

    @SuppressLint("SetTextI18n")
    private fun ShowResult(result:Boolean)
    {
        binding.result.visibility = android.view.View.VISIBLE
        if(result)
        {
            binding.result.text = "You are right!"
        }
        else
        {
            binding.result.text = "You are wrong!"
        }
        Handler(Looper.getMainLooper()).postDelayed( {
            val intent = Intent()
            intent.putExtra(LdsPictureActivity.RIGHT, result)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }, 1000)
    }
}