package com.training.notes.db

import com.training.notes.model.Note

interface NotesDao {
    fun addNote(note: Note)
    fun getNotes(): List<Note>
    fun getNote(position: Int): Note
}