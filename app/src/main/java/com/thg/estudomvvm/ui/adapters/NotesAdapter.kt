package com.thg.estudomvvm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thg.estudomvvm.R
import com.thg.estudomvvm.data.Note
import kotlinx.android.synthetic.main.item_note.view.*

class NotesAdapter(val data: MutableList<Note> = mutableListOf()): RecyclerView.Adapter<NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) = holder.bindView(data[position])

    fun add(item: Note) {
        data.add(item)
        notifyDataSetChanged()
    }

    fun add(itens: List<Note>) {
        data.clear()
        data.addAll(itens)
        notifyDataSetChanged()
    }

    fun remove(item: Note) {
        data.remove(item)
        notifyDataSetChanged()
    }
}

class NoteViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bindView(item: Note) {
        with(view) {
            tvItemNote.text = item.text
        }
    }
}