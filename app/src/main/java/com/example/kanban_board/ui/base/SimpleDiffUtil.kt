package com.example.kanban_board.ui.base

import androidx.recyclerview.widget.DiffUtil

class SimpleDiffUtil<T>(
    private val oldItems: List<T>,
    private val newItems: List<T>,
    private val checkSameItem: (oldItem: T, newItem: T) -> Boolean,
): DiffUtil.Callback(){
    override fun getOldListSize() = oldItems.size
    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        checkSameItem(oldItems[oldItemPosition], newItems[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true

}