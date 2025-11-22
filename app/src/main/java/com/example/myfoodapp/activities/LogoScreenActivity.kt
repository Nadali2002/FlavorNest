package com.example.myfoodapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myfoodapp.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LogoScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logo_screen)

        val logoImage = findViewById<ImageView>(R.id.imageViewLogo)

        // Start small and transparent
        logoImage.scaleX = 0.5f
        logoImage.scaleY = 0.5f
        logoImage.alpha = 0f

        // Animate to full size and fully visible over 1 second
        logoImage.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(1000)
            .start()

        // Navigate to OnboardingScreen1 after 3 seconds
        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(this@LogoScreenActivity, OnboardingScreen1::class.java)
            startActivity(intent)
            finish() // prevent going back to logo screen
        }
    }
}