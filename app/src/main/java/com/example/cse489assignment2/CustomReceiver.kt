package com.example.cse489assignment2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val message = intent?.getStringExtra("message")

        Toast.makeText(
            context,
            "Received: $message",
            Toast.LENGTH_LONG
        ).show()
    }
}