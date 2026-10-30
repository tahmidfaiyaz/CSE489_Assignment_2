package com.example.cse489assignment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import android.content.Intent

class BroadcastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(
            R.layout.fragment_broadcast,
            container,
            false
        )

        val spinner =
            view.findViewById<Spinner>(R.id.broadcastSpinner)

        val proceedButton =
            view.findViewById<Button>(R.id.proceedButton)

        val options = arrayOf(
            "Custom broadcast receiver",
            "System battery notification receiver"
        )

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            options
        )

        adapter.setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )

        spinner.adapter = adapter

        proceedButton.setOnClickListener {

            val selectedOption =
                spinner.selectedItem.toString()

            if (selectedOption == "Custom broadcast receiver") {

                val intent = Intent(
                    requireContext(),
                    CustomBroadcastActivity::class.java
                )

                startActivity(intent)

            } else {

                val intent = Intent(
                    requireContext(),
                    BatteryActivity::class.java
                )

                startActivity(intent)
            }
        }

        return view
    }
}