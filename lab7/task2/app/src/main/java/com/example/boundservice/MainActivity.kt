package com.example.boundservice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent(this, BindService::class.java).also {
            Toast.makeText(this, "Your bound service has been started", Toast.LENGTH_SHORT).show()
        }

        val btnGoToList = findViewById<Button>(R.id.btn_go_to_list)
        btnGoToList.setOnClickListener {
            Intent(this, ListActivity::class.java).also {
                startActivity(it)
            }
        }

        val btnGetCounter = findViewById<Button>(R.id.btn_get_counter_from_bind_service)
        btnGetCounter.setOnClickListener {
            Toast.makeText(this, "Counter: ${BindService().counter}", Toast.LENGTH_SHORT).show()
        }
    }

}
