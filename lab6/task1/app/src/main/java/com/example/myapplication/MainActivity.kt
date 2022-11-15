package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE)

        val button = findViewById<Button>(R.id.btnSave)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.etInput)
            val text = editText.text.toString()
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("STRING_KEY", text)
            }.apply()
        }

        val savedString = sharedPreferences.getString("STRING_KEY", null)
        val editText = findViewById<EditText>(R.id.etInput)
        editText.setText(savedString)
    }

}