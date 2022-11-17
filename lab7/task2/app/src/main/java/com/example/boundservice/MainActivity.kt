package com.example.boundservice

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var countServiceBinder: BindService? = null
    private var bounded: Boolean = false

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as BindService.BindServiceNew
            countServiceBinder = binder.getService()
            bounded = true
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            countServiceBinder = null
            bounded = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent(applicationContext, BindService::class.java).also { intent ->
            bindService(
                intent,
                connection,
                BIND_AUTO_CREATE
            )
        }

        findViewById<Button>(R.id.btn_get_counter_from_bind_service).setOnClickListener {
            Toast.makeText(
                applicationContext,
                "" + (countServiceBinder?.incrementVar ?: ""),
                Toast.LENGTH_SHORT
            ).show()
        }

        findViewById<Button>(R.id.btn_go_to_list).setOnClickListener {
            unbindSafely()
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun unbindSafely() {
        if (bounded) {
            unbindService(connection)
            bounded = false
        }
    }

    override fun onStop() {
        unbindSafely()
        super.onStop()
    }

}
