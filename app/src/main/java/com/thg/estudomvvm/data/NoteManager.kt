package com.thg.estudomvvm.data

class NoteManager(private val database: Database) {

    fun getNotes() = database.getNotes()

    fun addNote(note: Note) = database.insertNote(note)
}