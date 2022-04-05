package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MdsMakeSentenceSpellBinding
import java.util.*
import kotlin.collections.mutableListOf

class MdsMakeSentenceActivity : AppCompatActivity() {
    lateinit var binding: MdsMakeSentenceSpellBinding

    private var list = mutableListOf<String>()
    private lateinit var adapter : MdsAdapter
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MdsMakeSentenceSpellBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = linearLayoutManager

        val items = fetchData()
        list.add("suka  ")
        list.add("blyat ")
        list.add("nahui ")

        adapter = MdsAdapter(list)
        recyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
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

            Collections.swap(list, fromPosition, toPosition)

            recyclerView.adapter?.notifyItemMoved(fromPosition, toPosition)

            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            TODO("Not yet implemented")
        }
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
}