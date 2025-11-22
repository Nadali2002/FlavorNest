package com.example.myfoodapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myfoodapp.R
import com.example.myfoodapp.activities.WelcomeActivity

class OnboardingScreenActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboarding_screen3)

        //Get the root layout properly
        val mainLayout = findViewById<ConstraintLayout>(R.id.main)

        // Handle system insets (status bar, navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBarsInsets.left,
                systemBarsInsets.top,
                systemBarsInsets.right,
                systemBarsInsets.bottom
            )
            insets
        }

        //Find Next button
        val nextButton = findViewById<Button>(R.id.btnNext)

        //Navigate to WelcomeActivity when clicked
        nextButton.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish() // Optional: remove onboarding from backstack
        }
    }
}