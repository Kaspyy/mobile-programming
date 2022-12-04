package com.example.studentlist


import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val studentName = findViewById<EditText>(R.id.editStudentName)
        val addButton = findViewById<android.widget.Button>(R.id.addButton)

        addButton.setOnClickListener {
            val name = studentName.text.toString()
            val db = MyDatabaseHelper(this)

            db.addStudent(name)

            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            recreate()
        }
    }
}