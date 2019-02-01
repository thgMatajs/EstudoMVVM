package com.thg.estudomvvm.di

import com.thg.estudomvvm.data.Database
import com.thg.estudomvvm.data.NoteManager
import com.thg.estudomvvm.viewmodels.NotesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

object KoinModules {

    val appModule = module {

        single { Database() }
        factory { NoteManager(get()) }

        viewModel { NotesViewModel(get()) }
    }
}