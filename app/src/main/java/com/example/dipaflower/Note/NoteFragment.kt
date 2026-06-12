package com.example.dipaflower.Note

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dipaflower.R
import com.example.dipaflower.data.entity.NoteEntity
import com.example.dipaflower.data.model.AppDatabase
import com.example.dipaflower.databinding.FragmentMoreBinding
import com.example.dipaflower.databinding.FragmentNoteBinding
import kotlinx.coroutines.launch
import kotlin.jvm.java


class NoteFragment : Fragment() {
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NoteAdapter
    private lateinit var db: AppDatabase
    private val notes = mutableListOf<NoteEntity>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentNoteBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }
        binding.fabAddNote.setOnClickListener {
            startActivity(Intent(requireContext(), NoteFromActivity::class.java))

            /** Inisialisasi AppDatabase & Adapter **/
            db = AppDatabase.getInstance(requireContext())
            adapter = NoteAdapter(notes, this)

            binding.rvNotes.layoutManager = LinearLayoutManager(requireContext())
            binding.rvNotes.adapter = adapter

            /** Tambah ini sebagai garis pemisah **/
            val dividerItemDecoration =
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            binding.rvNotes.addItemDecoration(dividerItemDecoration)
//
            fetchNotes()
        }
    }

    private fun fetchNotes() {
        lifecycleScope.launch {
//            val data = db.noteDao().getAll() //pemanggilan query
//            notes.clear()
//            notes.addAll(data)
//            adapter.notifyDataSetChanged()
        }
    }

    fun deleteNote(note: NoteEntity) {
        lifecycleScope.launch {
            db.noteDao().delete(note) //Hapus Note
            fetchNotes()              //Fetch lagi data notes terbaru
        }
    }

    override fun onResume() {
        super.onResume()
        fetchNotes()
    }
}

