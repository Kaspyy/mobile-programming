package com.example.studentlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val editStudentName = findViewById<EditText>(R.id.editStudentName)
        val addButton = findViewById<Button>(R.id.addButton)
        
        addButton.setOnClickListener {
            val myDB = MyDatabaseHelper(this)
            myDB.addStudent(editStudentName.text.toString().trim())
        }
    }
}