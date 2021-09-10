package com.example.kanban_board.ui.notes

import android.view.animation.AnimationUtils
import com.example.kanban_board.R
import com.example.kanban_board.data.Note
import com.example.kanban_board.ui.base.BaseAdapter
import com.example.kanban_board.ui.base.BaseInteractionListener

class NoteAdapter(items: List<Note>, listener: NoteInteractionListener): BaseAdapter<Note>(items, listener) {
    override val layoutId: Int = R.layout.item_note
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.cards_anim)
    }

}

interface NoteInteractionListener: BaseInteractionListener {
    fun onClickNote(note: Note)
    fun onClickDeleteButton(note: Note)
}

