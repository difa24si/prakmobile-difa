package com.example.dipaflower.Message

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.dipaflower.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(

    context: Context,

    private val messages: List<MessageModel>

) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {

        // VIEW BINDING
        val binding = ItemMessageBinding.inflate(
            LayoutInflater.from(context),
            parent,
            false
        )

        // GET DATA
        val message = messages[position]

        // LOAD IMAGE
        Glide.with(context)
            .load(message.avatarUrl)
            .into(binding.avatarImg)

        // SET TEXT
        binding.textSender.text =
            message.senderName

        binding.textMessage.text =
            message.messageText

        // CLICK ITEM
        binding.root.setOnClickListener {

            Snackbar.make(
                parent,
                "Pesan dari ${message.senderName}: ${message.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}