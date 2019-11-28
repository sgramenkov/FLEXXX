package com.example.fiinaltask

import android.app.IntentService
import android.content.Intent
import android.util.Log

class BonchDevIntentService : IntentService("BonchDevService") {

    val DEBUG_TAG = "BONCHDEV_SERVICE"


    override fun onCreate() {
        Log.d(DEBUG_TAG, "onCreate() called")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(DEBUG_TAG, "onStartCommand(...) called")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.d(DEBUG_TAG, "onHandleIntent(...) called")
        Thread.sleep(5000)
        Log.d(DEBUG_TAG, "Intent handled")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(DEBUG_TAG, "onDestroy() called")
    }

}