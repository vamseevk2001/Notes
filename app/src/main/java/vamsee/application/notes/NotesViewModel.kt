package vamsee.application.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>

    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        val repository = NotesRepository(dao)
        allNotes = repository.allnotes
    }


}