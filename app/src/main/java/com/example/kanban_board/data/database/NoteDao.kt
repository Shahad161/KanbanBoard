package com.example.kanban_board.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kanban_board.data.Note
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import java.util.*

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note): Completable

    @Delete
    fun delete(note: Note): Completable

    @Query("UPDATE NOTE_TABLE SET assigned = :assigned ,description= :description ,date= :date,in_backlog= :in_backlog, progress= :progress, done= :done WHERE id=:id")
    fun update(id:Int, assigned:String, description:String,date: Date, in_backlog:Boolean, progress:Boolean, done:Boolean ): Completable

    @Query("SELECT * FROM NOTE_TABLE ORDER BY id DESC")
    fun getAllNote(): LiveData<List<Note>>

    @Query("SELECT * FROM NOTE_TABLE WHERE  in_backlog = 1")
    fun getBacklog(): LiveData<List<Note>>
}