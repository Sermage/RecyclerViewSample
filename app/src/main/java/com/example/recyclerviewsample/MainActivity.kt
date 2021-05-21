package com.example.recyclerviewsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfItems = mutableListOf("First", "Second", "Third", "Forth", "Fifth")
        val layoutManager=LinearLayoutManager(this)
        val adapter = Adapter(listOfItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager=layoutManager
        val itemDecoration=DividerItemDecoration(recyclerView.context,layoutManager.orientation)
        recyclerView.addItemDecoration(itemDecoration)

    }
}