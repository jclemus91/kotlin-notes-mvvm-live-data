package com.training.notes.repository.impl

import com.training.notes.db.NotesDao
import com.training.notes.model.Note
import com.training.notes.repository.NotesRepository

class NotesRepositoryImpl(private val notesDao: NotesDao) : NotesRepository {

    override fun addNote(note: Note) {
        notesDao.addNote(note)
    }

    override fun getNotes(): List<Note> = notesDao.getNotes()

    override fun getNote(position: Int): Note = notesDao.getNote(position)
}