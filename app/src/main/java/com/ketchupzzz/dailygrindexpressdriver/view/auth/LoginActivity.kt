package com.ketchupzzz.dailygrindexpressdriver.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ketchupzzz.dailygrindexpressdriver.MainActivity
import com.ketchupzzz.dailygrindexpressdriver.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonLoginWithGoogle.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}