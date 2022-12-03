package com.example.studentlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<android.widget.Button>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = android.content.Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}