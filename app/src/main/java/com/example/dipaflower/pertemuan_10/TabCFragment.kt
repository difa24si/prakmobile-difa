package com.example.dipaflower.pertemuan_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dipaflower.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(

        ProductModel("Sepatu Running Nike", "Rp 850.000", "https://picsum.photos/200?1"),
        ProductModel("Kemeja Flannel", "Rp 320.000", "https://picsum.photos/200?2"),
        ProductModel("Tas Ransel Laptop", "Rp 450.000", "https://picsum.photos/200?3"),
        ProductModel("Jam Tangan Casio", "Rp 1.200.000", "https://picsum.photos/200?4"),
        ProductModel("Headphone Sony", "Rp 1.500.000", "https://picsum.photos/200?5"),

        ProductModel("Kaos Polos Premium", "Rp 150.000", "https://picsum.photos/200?6"),
        ProductModel("Celana Jogger", "Rp 280.000", "https://picsum.photos/200?7"),
        ProductModel("Sneakers Adidas", "Rp 950.000", "https://picsum.photos/200?8"),
        ProductModel("Dompet Kulit", "Rp 220.000", "https://picsum.photos/200?9"),
        ProductModel("Topi Baseball", "Rp 120.000", "https://picsum.photos/200?10"),

        ProductModel("Mouse Gaming RGB", "Rp 275.000", "https://picsum.photos/200?11"),
        ProductModel("Keyboard Mechanical", "Rp 780.000", "https://picsum.photos/200?12"),
        ProductModel("Monitor LG 24 Inch", "Rp 2.100.000", "https://picsum.photos/200?13"),
        ProductModel("Power Bank 20000mAh", "Rp 350.000", "https://picsum.photos/200?14"),
        ProductModel("Charger Fast Charging", "Rp 180.000", "https://picsum.photos/200?15"),

        ProductModel("Kacamata Hitam", "Rp 260.000", "https://picsum.photos/200?16"),
        ProductModel("Sandal Gunung", "Rp 340.000", "https://picsum.photos/200?17"),
        ProductModel("Jaket Hoodie", "Rp 410.000", "https://picsum.photos/200?18"),
        ProductModel("Speaker Bluetooth", "Rp 620.000", "https://picsum.photos/200?19"),
        ProductModel("Tripod Kamera", "Rp 290.000", "https://picsum.photos/200?20"),

        ProductModel("Action Camera", "Rp 1.750.000", "https://picsum.photos/200?21"),
        ProductModel("Smartphone Samsung", "Rp 4.500.000", "https://picsum.photos/200?22"),
        ProductModel("Tablet Xiaomi", "Rp 3.250.000", "https://picsum.photos/200?23"),
        ProductModel("Laptop ASUS", "Rp 8.900.000", "https://picsum.photos/200?24"),
        ProductModel("Printer Epson", "Rp 2.350.000", "https://picsum.photos/200?25"),

        ProductModel("Flashdisk 64GB", "Rp 95.000", "https://picsum.photos/200?26"),
        ProductModel("Harddisk External", "Rp 850.000", "https://picsum.photos/200?27"),
        ProductModel("Kursi Gaming", "Rp 1.950.000", "https://picsum.photos/200?28"),
        ProductModel("Meja Kerja Minimalis", "Rp 1.450.000", "https://picsum.photos/200?29"),
        ProductModel("Lampu LED RGB", "Rp 175.000", "https://picsum.photos/200?30"),

        ProductModel("Kompor Portable", "Rp 230.000", "https://picsum.photos/200?31"),
        ProductModel("Blender Philips", "Rp 540.000", "https://picsum.photos/200?32"),
        ProductModel("Rice Cooker", "Rp 480.000", "https://picsum.photos/200?33"),
        ProductModel("Vacuum Cleaner", "Rp 1.250.000", "https://picsum.photos/200?34"),
        ProductModel("Dispenser Air", "Rp 780.000", "https://picsum.photos/200?35"),

        ProductModel("Botol Minum Tumbler", "Rp 110.000", "https://picsum.photos/200?36"),
        ProductModel("Payung Lipat", "Rp 95.000", "https://picsum.photos/200?37"),
        ProductModel("Bantal Leher Travel", "Rp 85.000", "https://picsum.photos/200?38"),
        ProductModel("Koper Kabin", "Rp 680.000", "https://picsum.photos/200?39"),
        ProductModel("Sepeda Lipat", "Rp 3.800.000", "https://picsum.photos/200?40"),

        ProductModel("Helm Full Face", "Rp 920.000", "https://picsum.photos/200?41"),
        ProductModel("Sarung Tangan Motor", "Rp 140.000", "https://picsum.photos/200?42"),
        ProductModel("Rak Buku Minimalis", "Rp 520.000", "https://picsum.photos/200?43"),
        ProductModel("Novel Best Seller", "Rp 98.000", "https://picsum.photos/200?44"),
        ProductModel("Paket Alat Lukis", "Rp 350.000", "https://picsum.photos/200?45"),

        ProductModel("Gitar Akustik", "Rp 1.600.000", "https://picsum.photos/200?46"),
        ProductModel("Piano Keyboard", "Rp 2.750.000", "https://picsum.photos/200?47"),
        ProductModel("Drone Mini", "Rp 1.950.000", "https://picsum.photos/200?48"),
        ProductModel("Smartwatch Xiaomi", "Rp 670.000", "https://picsum.photos/200?49"),
        ProductModel("Router WiFi", "Rp 430.000", "https://picsum.photos/200?50")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ProductAdapter(productList) { selectedItem ->

            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvProducts.apply {

            layoutManager = GridLayoutManager(requireContext(), 2)

            // Jika ingin Linear Layout
            // layoutManager = LinearLayoutManager(requireContext())

            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}