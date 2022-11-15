package com.example.boundservice

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast

class BindService : Service() {
    var counter = 0

    override fun onBind(p0: Intent?): IBinder? = null

    val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            counter++
            Toast.makeText(
                this@BindService,
                "Your bound service is still working",
                Toast.LENGTH_SHORT
            ).show()
            handler.postDelayed(this, 5000)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        handler.post(runnable)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
        Toast.makeText(this, "Your bound service has been destroyed", Toast.LENGTH_SHORT).show()
    }

}