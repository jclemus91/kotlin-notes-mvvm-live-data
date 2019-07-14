package com.training.notes.ui.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class NotesViewModel(
    private val notesRepository: NotesRepository
) : ViewModel() {

    val notesLive = MutableLiveData<List<Note>>()

    fun setUp() {
        notesLive.value = notesRepository.getNotes()
    }
}
