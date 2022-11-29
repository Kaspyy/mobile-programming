package com.example.studentlist

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UpdateActivity : AppCompatActivity() {
    val id: String? = null
    var name: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val updateButton: Button = findViewById(R.id.updateButton)
        val myDB = MyDatabaseHelper(this)
        val id = intent.getStringExtra("id")
        val name = findViewById<EditText>(R.id.updateStudentName)

        getAndSetIntentData()

        updateButton.setOnClickListener {
            myDB.updateData(id, name.text.toString())
        }
    }

    private fun getAndSetIntentData() {
        if (intent.hasExtra("id") && intent.hasExtra("name")) {
            val id = intent.getStringExtra("id")
            name = intent.getStringExtra("name")

            val updateStudentName: EditText = findViewById(R.id.updateStudentName)
            updateStudentName.setText(name)
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show()
        }
    }

}