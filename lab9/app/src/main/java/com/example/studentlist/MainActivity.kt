package com.example.studentlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private val myDB = MyDatabaseHelper(this)
    val studentList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storeDataInArray()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val addButton = findViewById<FloatingActionButton>(R.id.addButton)
        addButton.setOnClickListener {
            val intent = android.content.Intent(this, AddActivity::class.java)
            startActivity(intent)
        }

        val customAdapter = CustomAdapter(MainActivity(), studentList)
        recyclerView.adapter = customAdapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }

    private fun storeDataInArray() {
        val cursor = myDB.readData()
        if (cursor != null) {
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
}