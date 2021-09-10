package com.example.kanban_board.data.repositories

import androidx.lifecycle.LiveData
import com.example.kanban_board.data.Note
import com.example.kanban_board.data.database.NoteDatabase
import io.reactivex.rxjava3.core.Completable
import java.util.*

class NoteRepository {

    var dao = NoteDatabase.getInstanceWithContext().noteDoa()

    fun  insertNewNote(note: Note): Completable{
        return dao.insertNote(note)
    }

    fun  updateNote(id:Int, assigned:String, description:String, date: Date, in_backlog:Boolean, progress:Boolean, done:Boolean): Completable{
        return dao.update(id, assigned, description, date, in_backlog, progress, done)
    }

    fun getAllNote(): LiveData<List<Note>> = dao.getAllNote()
    fun getBacklogNote(): LiveData<List<Note>> = dao.getBacklog()


    fun deleteNote(note: Note) = dao.delete(note)

}