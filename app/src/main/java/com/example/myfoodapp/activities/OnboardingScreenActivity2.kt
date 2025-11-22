package com.example.myfoodapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myfoodapp.activities.OnboardingScreenActivity3
import com.example.myfoodapp.R

class OnboardingScreen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding_screen2)

        val btnNext = findViewById<Button>(R.id.btnNext)
        btnNext.setOnClickListener {
            // Navigate to OnboardingScreen2
            val intent = Intent(this, OnboardingScreenActivity3::class.java)
            startActivity(intent)
            finish() // optional: prevents going back to OnboardingScreen1
        }
    }
}
