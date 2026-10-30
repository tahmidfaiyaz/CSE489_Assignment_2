package com.example.cse489assignment2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
class CustomBroadcastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_custom_broadcast)

        val messageInput =
            findViewById<EditText>(R.id.messageInput)

        val sendButton =
            findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {

            val message = messageInput.text.toString()

            if (message.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter a message",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val intent = Intent(
                    this,
                    CustomReceiver::class.java
                )

                intent.putExtra(
                    "message",
                    message
                )

                sendBroadcast(intent)
            }
        }
    }
}