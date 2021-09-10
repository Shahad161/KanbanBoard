package com.example.kanban_board.ui.updateNote

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanban_board.data.Note
import com.example.kanban_board.data.repositories.NoteRepository
import com.example.kanban_board.ui.notes.NoteInteractionListener
import com.example.kanban_board.utils.StatusSelect
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*


class UpdateNoteViewModel: ViewModel(), NoteInteractionListener {

    private val status = StatusSelect()
    private val repository = NoteRepository()

    var updateItem = MutableLiveData<Note>()
    var assigned= MutableLiveData<String>()
    var description= MutableLiveData<String>()


    fun updateNote(){
        repository.updateNote(
            updateItem.value?.id!!.toInt(),
            assigned.value.toString(),
            description.value.toString(),
            Date(),
            status.statusList.getValue("backlog"),
            status.statusList.getValue("progress"),
            status.statusList.getValue("done")
            )
            .subscribeOn(Schedulers.io())
            .subscribe()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun option(optionId: Int){
        status.selectOption(optionId)
    }

    override fun onClickNote(note: Note) {
    }

    override fun onClickDeleteButton(note: Note) {
        TODO("Not yet implemented")
    }

}