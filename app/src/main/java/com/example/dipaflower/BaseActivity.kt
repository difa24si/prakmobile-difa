package com.example.dipaflower

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.dipaflower.Home.HomeFragment
import com.example.dipaflower.Message.MessageFragment
import com.example.dipaflower.Message.tutorial.TutorialMessageActivity
import com.example.dipaflower.More.MoreFragment
import com.example.dipaflower.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                0
            )

            insets
        }

        // Toolbar Menu
        binding.toolbar.setOnMenuItemClickListener {

            when (it.itemId) {

                R.id.action_search -> {

                    Toast.makeText(
                        this,
                        "Search Clicked",
                        Toast.LENGTH_SHORT
                    ).show()

                    true
                }

                R.id.action_tutorial -> {

                    AlertDialog.Builder(this)
                        .setTitle("Tutorial Aplikasi")
                        .setMessage(
                            "Pelajari cara menggunakan fitur Home, Message dan More."
                        )
                        .setPositiveButton("Mulai Tutorial") { _, _ ->

                            startActivity(
                                Intent(
                                    this,
                                    TutorialMessageActivity::class.java
                                )
                            )
                        }
                        .setNegativeButton("Batal", null)
                        .show()

                    true
                }

                R.id.action_settings -> {

                    Toast.makeText(
                        this,
                        "Settings Clicked",
                        Toast.LENGTH_SHORT
                    ).show()

                    true
                }

                else -> false
            }
        }

        // Toolbar Navigation Icon
        binding.toolbar.setNavigationOnClickListener {

            Toast.makeText(
                this,
                "Menu Clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Fragment Awal
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
        }

        // Bottom Navigation
        binding.bottomNavView.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.home -> {

                    replaceFragment(
                        HomeFragment()
                    )

                    true
                }

                R.id.message -> {

                    replaceFragment(
                        MessageFragment()
                    )

                    true
                }

                R.id.more -> {

                    replaceFragment(
                        MoreFragment()
                    )

                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(
        fragment: Fragment
    ) {

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.fragment_container,
                fragment
            )
            .commit()
    }
}