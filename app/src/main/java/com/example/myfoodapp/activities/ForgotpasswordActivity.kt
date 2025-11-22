package com.example.myfoodapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myfoodapp.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.snackbar.Snackbar

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var newPassword: TextInputEditText
    private lateinit var confirmPassword: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword) // Make sure this file exists

        newPassword = findViewById(R.id.editNewPassword)
        confirmPassword = findViewById(R.id.editConfirmPassword)
    }

    // Continue button click
    fun continueClick(view: View) {
        val newPass = newPassword.text.toString().trim()
        val confirmPass = confirmPassword.text.toString().trim()

        // Empty field validation
        if (newPass.isEmpty() || confirmPass.isEmpty()) {
            Snackbar.make(view, "Please enter both fields", Snackbar.LENGTH_SHORT).show()
            return
        }

        // Password match validation
        if (newPass != confirmPass) {
            Snackbar.make(view, "Passwords do not match", Snackbar.LENGTH_SHORT).show()
            return
        }

        // Navigate to LoginActivity if validation passes
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish() // Optional: prevents user from going back to forgot password screen
    }
}
