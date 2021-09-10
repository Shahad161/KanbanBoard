package com.example.kanban_board.data.database

import androidx.room.TypeConverter
import java.util.*


class Converters {

    @TypeConverter
    fun dateToLong(date: Date): Long {
        return date.time

    }

    @TypeConverter
    fun longToDate(long: Long): Date{
        return Date(long)
    }



}