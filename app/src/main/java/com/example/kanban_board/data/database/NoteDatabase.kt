package com.example.kanban_board.data.database

import android.content.Context
import androidx.room.*
import com.example.kanban_board.data.Note


@Database(entities = [Note::class], version = 1)
@TypeConverters(Converters::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDoa(): NoteDao

    companion object{

        private const val DATABASE_NAME = "myNoteDatabase"
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase{
            return instance ?: synchronized(this){buildDatabase(context).also{ instance = it }}
        }

        fun getInstanceWithContext(): NoteDatabase{
            return instance!!
        }

        private fun buildDatabase(context: Context): NoteDatabase{
            return Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME).build()
        }

    }

}