package com.training.notes.ui.detail

import androidx.lifecycle.ViewModel;
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class NoteDetailViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    fun getNote(position: Int): Note {
        return notesRepository.getNote(position)
    }

}
