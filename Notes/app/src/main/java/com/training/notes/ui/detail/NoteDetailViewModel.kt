package com.training.notes.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class NoteDetailViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    val noteLive = MutableLiveData<Note>()

    fun setUp(position: Int) {
        noteLive.value = notesRepository.getNote(position)
    }
}
