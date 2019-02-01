package com.thg.estudomvvm.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import com.thg.estudomvvm.R
import com.thg.estudomvvm.data.Note
import com.thg.estudomvvm.ui.adapters.NotesAdapter
import com.thg.estudomvvm.viewmodels.NotesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity :  AppCompatActivity() {

    private val notesViewModel: NotesViewModel by viewModel()
    private val notesAdapter: NotesAdapter by lazy {
        NotesAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRv()
        initViewModel()
    }

    private fun initViewModel() {
//        notesViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        notesViewModel.getNotes().observe(this, Observer { notes ->
            notes?.let {
                notesAdapter.add(notes)
            }
        })
    }

    private fun initRv() {
        rvNotes.adapter = notesAdapter
        rvNotes.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId) {
            R.id.menuAdd -> {
                dialogAddNote()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun dialogAddNote() {
        val customLayout = LayoutInflater.from(this).inflate(R.layout.dialog_ui, null, false)
        val inputNote = customLayout.findViewById<TextInputEditText>(R.id.edtNote)
        AlertDialog.Builder(this).apply {
            setView(customLayout)
            setPositiveButton("Salvar") { d, i ->
                val note = Note(0, inputNote.text.toString())
                notesViewModel.saveNote(note)
            }
            setNegativeButton("Cancelar", null)
            create()
        }.show()


    }
}
