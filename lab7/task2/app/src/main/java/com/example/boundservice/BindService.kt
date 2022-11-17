package com.example.boundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.widget.Toast

class BindService : Service() {
    private val binder = BindServiceNew()
    lateinit var handlerThread: HandlerThread
    lateinit var handler: Handler

    var incrementVar: Int = 0
    var loopWhile = false

    inner class BindServiceNew : Binder() {
        fun getService(): BindService = this@BindService
    }

    override fun onBind(intent: Intent): IBinder {
        Toast.makeText(
            applicationContext,
            "Your bound service has been started",
            Toast.LENGTH_SHORT
        ).show()
        return binder
    }

    override fun onUnbind(intent: Intent?): Boolean {
        loopWhile = false
        handler.removeCallbacksAndMessages(null)
        handler.looper.quit()
        handlerThread.quit()
        Toast.makeText(
            applicationContext,
            "Your bound service has been stopped",
            Toast.LENGTH_SHORT
        ).show()
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        handlerThread = HandlerThread("thread_name")
        handlerThread.start()
        handler = Handler(handlerThread.looper)
        handler.post {
            loopWhile = true
            while (loopWhile) {
                Thread.sleep(1000)
                incrementVar++
                if (incrementVar % 10 == 0) {
                    Toast.makeText(
                        applicationContext,
                        "Your bound service is still working",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}