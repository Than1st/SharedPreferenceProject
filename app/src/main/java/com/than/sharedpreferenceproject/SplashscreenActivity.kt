package com.than.sharedpreferenceproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.than.sharedpreferenceproject.databinding.ActivitySplashscreenBinding

@Suppress("DEPRECATION")
class SplashscreenActivity : AppCompatActivity() {
    private val sharedPrefFile = "kotlinsharedpreference"
    lateinit var binding: ActivitySplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            goHomeScreen()
            finish()
        }, 3000)
    }
    private fun goHomeScreen() {
        val sharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val sharedUsername = sharedPreferences.getString("username", "defaultUsername")
        val sharedPassword = sharedPreferences.getString("password", "defaultPassword")
        if (sharedUsername.equals("defaultUsername") && sharedPassword.equals("defaultPassword")){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}