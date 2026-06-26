package com.example.dipaflower.pertemuan_3

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.dipaflower.R
import com.example.dipaflower.databinding.ActivityThirdBinding
import com.example.dipaflower.utils.NotificationHelper
import com.example.dipaflower.utils.PermissionHelper

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

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
        enableEdgeToEdge()

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars =
                insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }

        // ==========================
        // Permission Notification
        // ==========================
        if (PermissionHelper.isNotificationPermissionRequired()) {

            val permission = Manifest.permission.POST_NOTIFICATIONS

            if (!PermissionHelper.hasPermission(this, permission)) {

                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        // ==========================
        // Tombol Submit
        // ==========================
        binding.btnSubmit.setOnClickListener {

            val no = binding.inputNo.text.toString()

            Log.e(
                "Klik btnSubmit",
                "Nomor Tujuan = $no"
            )

            val intent = Intent(
                this,
                ThirdResultActivity::class.java
            )

            // Ganti startActivity() menjadi Notification

            NotificationHelper.showNotification(
                this,
                "Pesanan Anda",
                "Halo $no, Pesanan Anda Sedang Diproses",
                intent
            )

            Toast.makeText(
                this,
                "Notifikasi berhasil dikirim",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}