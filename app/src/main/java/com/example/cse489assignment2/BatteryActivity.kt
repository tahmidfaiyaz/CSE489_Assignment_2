package com.example.cse489assignment2

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BatteryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_battery)

        val batteryText =
            findViewById<TextView>(R.id.batteryText)

        val batteryIntent = registerReceiver(
            null,
            IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        )

        val level =
            batteryIntent?.getIntExtra(
                BatteryManager.EXTRA_LEVEL,
                -1
            ) ?: -1

        val scale =
            batteryIntent?.getIntExtra(
                BatteryManager.EXTRA_SCALE,
                -1
            ) ?: -1

        val batteryPercentage =
            if (level >= 0 && scale > 0) {
                level * 100 / scale
            } else {
                0
            }

        batteryText.text =
            "Battery: $batteryPercentage%"
    }
}