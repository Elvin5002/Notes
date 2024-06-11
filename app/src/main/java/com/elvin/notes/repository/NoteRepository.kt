package com.elvin.notes.repository

import com.elvin.notes.dao.NoteDatabase
import com.elvin.notes.model.Note

//burda depolayiriq(hovuz, elaqelendirici) ui data ayirir (melumat merkezlesdir)
class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNote(note: Note) = db.getNoteDao().insertNote(note)

    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)

    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun searchNote(query: String?) = db.getNoteDao().searchNote(query)

    suspend fun getNoteById(id: Int) = db.getNoteDao().getNoteById(id)

    fun getAllNotes() = db.getNoteDao().getAllNotes()

}