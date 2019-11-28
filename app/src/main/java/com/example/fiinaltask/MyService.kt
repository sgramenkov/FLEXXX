package com.example.fiinaltask

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyService : Service() {

    val DEBUG_TAG = "BONCHDEV_SERVICE"
    val CHANNEL_ID = "0"

    private lateinit var notificationManager: NotificationManager

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(DEBUG_TAG, "onCreate() called")
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(DEBUG_TAG, "onStartCommand() called")
        startForeground(1, createNotification())
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(DEBUG_TAG, "onDestroy() called")
        super.onDestroy()
    }

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "Notification Channel 0",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createNotification() : Notification {
        val pendingIntent =
            PendingIntent.getActivity(this, 0, Intent(this, MainActivity::class.java), 0)
        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("BonchDev notification!")
            .setContentText("Hello!!!")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(false)
            .build()
    }
}
