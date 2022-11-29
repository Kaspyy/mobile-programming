package com.example.lightswitch

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment

class FlashlightFragment : Fragment(R.layout.fragment_flashlight) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.turnOnButton)
        button.setOnClickListener {
            if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }

    }
}
