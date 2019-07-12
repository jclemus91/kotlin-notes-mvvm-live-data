package com.training.notes.model

data class Note(
    val title: String,
    val message: String
) {
    override fun toString(): String {
        return "Note(title='$title', message='$message')"
    }
}