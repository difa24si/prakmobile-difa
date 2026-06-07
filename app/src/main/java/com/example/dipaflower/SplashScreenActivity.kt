package com.example.dipaflower

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_splash_screen
        )

        lifecycleScope.launch {

            delay(2000)

            // LANGSUNG KE BASE ACTIVITY
            startActivity(
                Intent(
                    this@SplashScreenActivity,
                    BaseActivity::class.java
                )
            )

            finish()
        }
    }
}