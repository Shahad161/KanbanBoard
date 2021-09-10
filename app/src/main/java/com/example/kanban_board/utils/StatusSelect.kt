package com.example.kanban_board.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.*

class StatusSelect {

    var statusList = mutableMapOf("backlog" to true, "progress" to false, "done" to false)

    @RequiresApi(Build.VERSION_CODES.O)
    fun selectOption(radioButton: Int){
        val hh = Date().toInstant()
        Log.i("kkk", hh.toString())

        if( radioButton == 1){
            statusList["backlog"] = true
            statusList["progress"] = false
            statusList["done"] = false
        }

        if( radioButton == 2){
            statusList["backlog"] = false
            statusList["progress"] = true
            statusList["done"] = false
        }

        if( radioButton == 3){
            statusList["backlog"] = false
            statusList["progress"] = false
            statusList["done"] = true
        }

    }
}