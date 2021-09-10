package com.example.kanban_board.data

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@SuppressLint("ParcelCreator")
@Entity(tableName = "NOTE_TABLE")
data class Note (

    @PrimaryKey(autoGenerate = true) val id: Long,
    val description: String,
    val assigned: String,
    val date: Date,
    @ColumnInfo(defaultValue = "0") val in_backlog: Boolean,
    @ColumnInfo(defaultValue = "0") val progress: Boolean,
    @ColumnInfo(defaultValue = "0") val done: Boolean,

    ): Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }
}