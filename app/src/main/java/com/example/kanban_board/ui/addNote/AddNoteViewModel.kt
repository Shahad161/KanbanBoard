package com.example.kanban_board.ui.addNote

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kanban_board.data.Note
import com.example.kanban_board.data.repositories.NoteRepository
import com.example.kanban_board.utils.StatusSelect
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*

class AddNoteViewModel: ViewModel() {

    private val repository = NoteRepository()
    private val status = StatusSelect()
    val descriptionText = MutableLiveData<String>()
    val assignedText = MutableLiveData<String>()


    fun addNote(){
        repository.insertNewNote(
            Note(0
                , descriptionText.value.toString()
                , assignedText.value.toString()
                , Date()
                , status.statusList.getValue("backlog")
                , status.statusList.getValue("progress")
                , status.statusList.getValue("done")
            ))
            .subscribeOn(Schedulers.io())
            .subscribe()

        descriptionText.value = ""
        assignedText.value = ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun option(optionId: Int){
        status.selectOption(optionId)
    }


}