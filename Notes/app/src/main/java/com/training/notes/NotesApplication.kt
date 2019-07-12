package com.training.notes

import android.app.Application
import com.training.notes.db.NotesDao
import com.training.notes.db.impl.NotesDaoImpl
import com.training.notes.repository.NotesRepository
import com.training.notes.repository.impl.NotesRepositoryImpl
import com.training.notes.ui.add.AddNoteViewModel
import com.training.notes.ui.detail.NoteDetailViewModel
import com.training.notes.ui.list.NotesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotesApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(repositoryModule)
            modules(viewModelModule)
        }
    }

    private val repositoryModule = module {
        single<NotesDao> { NotesDaoImpl() }
        single<NotesRepository> { NotesRepositoryImpl(get()) }
    }

    private val viewModelModule = module {
        viewModel { AddNoteViewModel(get()) }
        viewModel { NoteDetailViewModel(get()) }
        viewModel { NotesViewModel(get()) }
    }

}