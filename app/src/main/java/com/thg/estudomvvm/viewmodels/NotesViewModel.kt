package com.thg.estudomvvm.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thg.estudomvvm.data.Note
import com.thg.estudomvvm.data.NoteManager

class NotesViewModel(private val noteManager: NoteManager) : ViewModel() {

    private var mNotes: MutableLiveData<MutableList<Note>>? = null

    fun getNotes(): LiveData<MutableList<Note>> {
        if (mNotes == null) {
            mNotes = noteManager.getNotes()
        }

        return mNotes!!
    }

    fun saveNote(note: Note) {
        noteManager.addNote(note)
    }

}