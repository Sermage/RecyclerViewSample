package com.example.recyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listOfItems= mutableListOf("First","Second","Third","Forth","Fifth")
        val recyclerView=recyclerView
        val adapter= Adapter(listOfItems)
        recyclerView.adapter=adapter

    }
}