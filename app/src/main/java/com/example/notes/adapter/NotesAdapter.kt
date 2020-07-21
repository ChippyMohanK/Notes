package com.example.notes.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notes.R
import com.example.notes.model.Note
import com.example.notes.ui.NoteFragmentDirections
import kotlinx.android.synthetic.main.item_notes.view.*


class NotesAdapter(val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    class NoteViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size

    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.view.tvTitle.text = notes[position].title
        holder.view.tvDescription.text = notes[position].note
        holder.view.setOnClickListener {
            val action = NoteFragmentDirections.noteAdd()
            action.note = notes[position]
            Navigation.findNavController(it).navigate(action)
        }
    }
}