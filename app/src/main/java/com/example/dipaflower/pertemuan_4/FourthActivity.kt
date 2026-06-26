package com.example.dipaflower.pertemuan_4

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dipaflower.MainActivity
import com.example.dipaflower.databinding.ActivityFourthBinding
import com.example.dipaflower.utils.NotificationHelper
import com.example.dipaflower.utils.PermissionHelper
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFourthBinding

    private val notificationPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted ->

            if (isGranted) {
                Toast.makeText(
                    this,
                    "Notifikasi diizinkan",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Notifikasi ditolak",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.e("onCreate", "FourthActivity dibuat pertama kali")

        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ===========================
        // Permission Notification
        // ===========================
        if (PermissionHelper.isNotificationPermissionRequired()) {

            val permission = Manifest.permission.POST_NOTIFICATIONS

            if (!PermissionHelper.hasPermission(this, permission)) {

                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // ===========================
        // BUTTON SHOW SNACKBAR
        // ===========================
        binding.btnShowSnackbar.setOnClickListener {

            val intent = Intent(
                this,
                MainActivity::class.java
            )

            NotificationHelper.showNotification(
                this,
                "Pertemuan 4",
                "Ini adalah Notification dari FourthActivity",
                intent
            )
        }

        // ===========================
        // BUTTON ALERT DIALOG
        // ===========================
        binding.btnShowAlertDialog.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin melanjutkan?")
                .setPositiveButton("Ya") { dialog, _ ->

                    val intent = Intent(
                        this,
                        MainActivity::class.java
                    )

                    NotificationHelper.showNotification(
                        this,
                        "Data Berhasil",
                        "Data berhasil dikirim.",
                        intent
                    )

                    dialog.dismiss()

                    Log.e(
                        "Info Dialog",
                        "Anda memilih Ya!"
                    )
                }

                .setNegativeButton("Batal") { dialog, _ ->

                    dialog.dismiss()

                    Log.e(
                        "Info Dialog",
                        "Anda memilih Tidak!"
                    )
                }

                .show()
        }

        // ===========================
        // BUTTON BACK
        // ===========================
        binding.btnBack.setOnClickListener {

            finish()

        }

        // ===========================
        // DATA INTENT
        // ===========================
        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age", 0)

        Log.e(
            "Data Intent",
            "Nama: $name, Usia: $age, Asal: $from"
        )
    }

    override fun onStart() {
        super.onStart()
        Log.e(
            "onStart",
            "FourthActivity terlihat di layar"
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e(
            "onDestroy",
            "FourthActivity dihapus dari stack"
        )
    }
}