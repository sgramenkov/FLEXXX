package com.example.fiinaltask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var serviceIntent: Intent

    private lateinit var startButton: Button
    private lateinit var stopButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        setListener()
    }


    fun initViews() {
        startButton = findViewById(R.id.start_button)
        stopButton = findViewById(R.id.stop_button)
    }

    fun setListener() {
        startButton.setOnClickListener {
            serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
        }

        stopButton.setOnClickListener {
            stopService(serviceIntent)
        }

    }


}
