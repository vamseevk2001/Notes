package vamsee.application.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

    val allNotes: LiveData<List<Notes>>
    private val repository: NotesRepository

    init {
        val dao = NotesDatabase.getDatabase(application).getNotesDao()
        repository = NotesRepository(dao)
        allNotes = repository.allnotes
    }

    fun delete(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun insert(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }


}