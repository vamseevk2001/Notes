package vamsee.application.notes

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NotesDao) {
    val allnotes: LiveData<List<Notes>> = noteDao.fetchAll()

    suspend fun insert(note: Notes){
        noteDao.insert(note)
    }

    suspend fun delete(note: Notes){
        noteDao.delete(note)
    }

}