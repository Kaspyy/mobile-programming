package com.example.boundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Intent(this, BindService::class.java).also {
            stopService(it)
        }
    }
}