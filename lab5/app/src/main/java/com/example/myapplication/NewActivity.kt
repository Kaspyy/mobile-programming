package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class NewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val studentList = ArrayList<Student>()
        studentList.add(Student("Jan", "Kowalski"))
        studentList.add(Student("Adam", "Nowak"))
        studentList.add(Student("Piotr", "Kowalski"))

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = Adapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }

}