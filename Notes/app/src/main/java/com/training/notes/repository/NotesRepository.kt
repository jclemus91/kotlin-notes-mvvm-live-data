package com.training.notes.repository

import com.training.notes.model.Note

interface NotesRepository {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
    fun getNote(position: Int): Note
}