package com.example.lightswitch

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class HomeFragment: Fragment(R.layout.fragment_home) {
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val button = view.findViewById<Button>(R.id.button)
    button.setOnClickListener {
        val action = HomeFragmentDirections.actionHomeFragmentToFlashlightFragment()
        findNavController().navigate(action)

    }
}
}