package com.training.notes.ui.add

import androidx.lifecycle.ViewModel
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class AddNoteViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    fun addNote(title: String, message: String) {
        notesRepository.addNote(Note(title, message))
    }
}
