package com.example.studentlist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    private val myDB = MyDatabaseHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val buttonRemove = findViewById<Button>(R.id.buttonRemove)
        buttonRemove.setOnClickListener {
            val studentName = intent.getStringExtra("studentName")
            myDB.deleteOneRow(studentName!!)
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