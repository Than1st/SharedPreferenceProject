package com.than.sharedpreferenceproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.than.sharedpreferenceproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val sharedPrefFile = "kotlinsharedpreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPreferences = this.getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        // save
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()
            when {
                username.isEmpty() -> {
                    binding.etLayoutUsername.error = getString(R.string.error_username)
                }
                password.isEmpty() -> {
                    binding.etLayoutPassword.error = getString(R.string.error_password)
                }
                else -> {
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.apply()
                    val intent = Intent(this, HomePageActivity::class.java)
                    startActivity(intent)
                }
            }
        }

        // view
//        binding.btnView.setOnClickListener {
//            val sharedUsername = sharedPreferences.getString("username", "defaultUsername")
//            val sharedPassword = sharedPreferences.getString("password", "defaultPassword")
//            if (sharedUsername.equals("defaultUsername") && sharedPassword.equals("defaultPassword")){
//                binding.tvUsername.setText("Default Username $sharedUsername").toString()
//                binding.tvPassword.setText("Default Password $sharedPassword").toString()
//                Toast.makeText(this, "Data Kosong!", Toast.LENGTH_SHORT).show()
//            } else {
//                binding.tvUsername.text = sharedUsername.toString()
//                binding.tvPassword.text = sharedPassword.toString()
//                Toast.makeText(this, "Data Tampil!", Toast.LENGTH_SHORT).show()
//            }
//        }
    }


}