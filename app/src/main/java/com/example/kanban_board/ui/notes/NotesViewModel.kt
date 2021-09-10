package com.example.kanban_board.ui.notes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanban_board.data.Note
import com.example.kanban_board.data.repositories.NoteRepository
import io.reactivex.rxjava3.schedulers.Schedulers



class NotesViewModel: ViewModel(), NoteInteractionListener {

    private val repository = NoteRepository()

    private var _notes = repository.getAllNote()
    val notes: LiveData<List<Note>> = _notes
    val notesItem = MutableLiveData<Note>()


    override fun onClickNote(note: Note) {
        notesItem.postValue(note)
    }

    override fun onClickDeleteButton(note: Note) {
        repository.deleteNote(note)
            .subscribeOn(Schedulers.io())
            .subscribe()
    }


}