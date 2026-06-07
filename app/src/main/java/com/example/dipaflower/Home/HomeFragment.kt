package com.example.dipaflower.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dipaflower.Home.photo.PhotoAdapter
import com.example.dipaflower.databinding.FragmentHomeBinding
import com.example.dipaflower.pertemuan_10.TenthActivity
import com.example.dipaflower.pertemuan_2.SecondActivity
import com.example.dipaflower.pertemuan_3.ThirdActivity
import com.example.dipaflower.pertemuan_4.FourthActivity
import com.example.dipaflower.pertemuan_5.FifthActivity
import com.example.dipaflower.pertemuan_7.SeventhActivity
import com.example.dipaflower.pertemuan_9.NinthActivity
import kotlinx.coroutines.launch
import com.example.dipaflower.data.api.PhotoApiClient

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPertemuan2.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    SecondActivity::class.java
                )
            )
        }

        binding.btnPertemuan3.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    ThirdActivity::class.java
                )
            )
        }

        binding.btnPertemuan4.setOnClickListener {

            val intent = Intent(
                requireContext(),
                FourthActivity::class.java
            )

            intent.putExtra(
                "name",
                "Politeknik Caltex Riau"
            )

            intent.putExtra(
                "from",
                "Rumbai"
            )

            intent.putExtra(
                "age",
                25
            )

            startActivity(intent)
        }

        binding.btnPertemuan5.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    FifthActivity::class.java
                )
            )
        }

        binding.btnPertemuan7.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    SeventhActivity::class.java
                )
            )
        }

        binding.btnPertemuan9.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    NinthActivity::class.java
                )
            )
        }

        binding.btnPertemuan10.setOnClickListener {
            startActivity(
                Intent(
                    requireContext(),
                    TenthActivity::class.java
                )
            )
        }

        loadPhoto()
    }

    private fun loadPhoto() {

        viewLifecycleOwner.lifecycleScope.launch {

            try {

                val photos =
                    PhotoApiClient.apiService.getPhotos()

                val adapter =
                    PhotoAdapter(photos)

                binding.rvGallery.layoutManager =
                    LinearLayoutManager(
                        requireContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )

                binding.rvGallery.adapter =
                    adapter

            } catch (e: Exception) {

                Toast.makeText(
                    requireContext(),
                    "Gagal memuat gambar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}