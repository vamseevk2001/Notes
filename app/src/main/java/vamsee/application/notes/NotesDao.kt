package vamsee.application.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("Select * from notes_table order by id ASC")
    fun fetchAll() : LiveData<List<Notes>>

}