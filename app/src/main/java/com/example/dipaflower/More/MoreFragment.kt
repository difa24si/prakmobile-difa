package com.example.dipaflower.More

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.dipaflower.databinding.FragmentMoreBinding

class MoreFragment : Fragment() {

    // VIEW BINDING
    private var _binding: FragmentMoreBinding? = null
    private val binding get() = _binding!!

    // DATA LIST WITH DESC
    private val dataListWithDesc = listOf(

        mapOf(
            "title" to "Laravel CRUD App",
            "desc" to "Aplikasi CRUD menggunakan Laravel"
        ),

        mapOf(
            "title" to "CodeIgniter Project",
            "desc" to "Framework project kampus modern"
        ),

        mapOf(
            "title" to "UI/UX Mobile Design",
            "desc" to "Design tampilan Android modern"
        ),

        mapOf(
            "title" to "Android Kotlin",
            "desc" to "Pengembangan aplikasi Kotlin"
        ),

        mapOf(
            "title" to "Student Information System",
            "desc" to "Sistem informasi mahasiswa"
        ),

        mapOf(
            "title" to "Responsive Web Design",
            "desc" to "Website responsive semua device"
        ),

        mapOf(
            "title" to "Material Design",
            "desc" to "Implementasi material components"
        ),

        mapOf(
            "title" to "Bottom Navigation",
            "desc" to "Navigasi modern Android"
        ),

        mapOf(
            "title" to "RecyclerView Project",
            "desc" to "Menampilkan data dinamis"
        ),

        mapOf(
            "title" to "Database MySQL",
            "desc" to "Koneksi database MySQL"
        ),

        mapOf(
            "title" to "API Integration",
            "desc" to "Integrasi REST API Android"
        ),

        mapOf(
            "title" to "Login Authentication",
            "desc" to "Sistem login dan register"
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // INFLATE BINDING
        _binding = FragmentMoreBinding.inflate(
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

        // SIMPLE ADAPTER
        val adapter = SimpleAdapter(

            requireContext(),

            dataListWithDesc,

            android.R.layout.simple_list_item_2,

            arrayOf(
                "title",
                "desc"
            ),

            intArrayOf(
                android.R.id.text1,
                android.R.id.text2
            )
        )

        // SET ADAPTER
        binding.listViewItems.adapter = adapter

        // CLICK LIST ITEM
        binding.listViewItems.setOnItemClickListener { _, _, position, _ ->

            val selectedItem = dataListWithDesc[position]

            val title = selectedItem["title"]

            val desc = selectedItem["desc"]

            Toast.makeText(

                requireContext(),

                "Kamu memilih:\n$title\n$desc",

                Toast.LENGTH_SHORT

            ).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}