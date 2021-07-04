package vamsee.application.notes

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class NotesDatabase: RoomDatabase() {
    abstract fun getNotesDao() : NotesDao

    companion object{
        private var INSTANCE: NotesDatabase ?= null
        fun getDatabase(context: Context): NotesDatabase{
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NotesDatabase::class.java,
                    "Notes-Database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}


