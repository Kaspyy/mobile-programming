package com.example.studentlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val studentList = ArrayList<String>()
    private val myDB = MyDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        val adapter = CustomAdapter()

        addButton.setOnClickListener {
            val intent = android.content.Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        displayData()

        adapter.setData(studentList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }

    private fun displayData() {
        val cursor = myDB.readAllData()
        if (cursor.count == 0) {
            android.widget.Toast.makeText(this, "No data.", android.widget.Toast.LENGTH_SHORT)
                .show()
        } else {
            while (cursor.moveToNext()) {
                studentList.add(cursor.getString(1))
            }
        }
    }
}