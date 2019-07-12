package com.training.notes.ui.list

import androidx.lifecycle.ViewModel;
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class NotesViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    fun getNotes() : List<Note> {
        return notesRepository.getNotes()
    }
}
