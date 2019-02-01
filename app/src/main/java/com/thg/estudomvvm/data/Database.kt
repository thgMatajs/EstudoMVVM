package com.thg.estudomvvm.data

import androidx.lifecycle.MutableLiveData

class Database {

    private val database: MutableLiveData<MutableList<Note>> = MutableLiveData()

    fun insertNote(note: Note){
        var temp = database.value
        if (temp == null) {
            temp = mutableListOf()
            temp.add(note)
        } else {
            temp.add(note)
        }
        database.postValue(temp)
    }

    fun getNotes() = database
}