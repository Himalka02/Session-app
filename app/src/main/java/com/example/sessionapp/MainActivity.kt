package com.example.sessionapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        // Check if the user is logged in
        if (!sharedPreferences.getBoolean("isLoggedIn", false)) {
            // User is not logged in, redirect to login page
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Log out the user
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            // Redirect to login page after logout
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

    }
}