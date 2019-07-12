package com.training.notes.db.impl

import com.training.notes.db.NotesDao
import com.training.notes.db.dataBase
import com.training.notes.model.Note

class NotesDaoImpl : NotesDao {

    override fun addNote(note: Note) {
        dataBase += note
    }

    override fun getNotes(): List<Note> = dataBase

    override fun getNote(position: Int): Note = dataBase[position]
}